package com.dsrcorporation.ru.codereviewplatform.service;

import com.dsrcorporation.ru.codereviewplatform.model.dto.AnswerDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Answer;
import com.dsrcorporation.ru.codereviewplatform.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы с ответами.
 */
@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final AssignedTaskService assignedTaskService;
    private final AnswerStatusService answerStatusService;

    public Long save(final AnswerDto answerDto,
                     final Long accountId) {
        Answer answer = Answer.builder()
                .assignedTask(assignedTaskService
                        .getAssignedTaskByAccountIdAndTaskId(accountId, answerDto.getTaskId()))
                .answerStatus(answerStatusService.getByName("NOT_VIEWED"))
                .build();
        return answerRepository.save(answer).getId();
    }
}
