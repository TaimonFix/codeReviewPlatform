package com.dsrcorporation.ru.codereviewplatform.service;

import com.dsrcorporation.ru.codereviewplatform.mapper.CommentMapper;
import com.dsrcorporation.ru.codereviewplatform.model.dto.CommentDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Account;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Answer;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Comment;
import com.dsrcorporation.ru.codereviewplatform.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/** Сервис для работы с {@link Comment}. */
@Service
@RequiredArgsConstructor
public class CommentService {

    private final AccountService accountService;
    private final AnswerService answerService;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public Long save(final CommentDto commentDto) {
        Account account = accountService.findById(commentDto.getAccountId());
        Answer answer = answerService.findById(commentDto.getAnswerId());
        Comment comment = commentMapper.toEntity(commentDto);
        comment.setAccount(account);
        comment.setAnswer(answer);
        return commentRepository.save(comment).getId();
    }

    public List<CommentDto> findAllByAnswerId(final Long answerId) {
        return commentMapper.toDtoList(commentRepository.findAllByAnswerId(answerId));
    }
}
