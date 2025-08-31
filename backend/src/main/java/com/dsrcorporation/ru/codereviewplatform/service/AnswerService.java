package com.dsrcorporation.ru.codereviewplatform.service;

import com.dsrcorporation.ru.codereviewplatform.exception.EntityNotFoundException;
import com.dsrcorporation.ru.codereviewplatform.model.dto.AnswerDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Answer;
import com.dsrcorporation.ru.codereviewplatform.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

/** Сервис для работы с {@link Answer}. */
@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final AssignedTaskService assignedTaskService;
    private final AnswerStatusService answerStatusService;
    private final TaskService taskService;

    public Long save(final AnswerDto answerDto,
                     final Long accountId) {
        Answer answer = Answer.builder()
                .assignedTask(assignedTaskService
                        .getAssignedTaskByAccountIdAndTaskId(accountId, answerDto.getTaskId()))
                .answerStatus(answerStatusService.getByName("NOT_VIEWED"))
                .build();
        return answerRepository.save(answer).getId();
    }

    public Answer findById(final Long id) {
        return answerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Ответ под номером '" + id + "' не найден.")
        );
    }

    public String updateAnswerStatus(final Long teacherId,
                                     final Long answerId,
                                     final String status) {
        Answer answer = findById(answerId);
        Long taskId = answer.getAssignedTask().getTask().getId();
        if (!taskService.isTaskCreator(teacherId, taskId)) {
            throw new AccessDeniedException("Вы не можете обновлять статус этого задания!");
        }
        answer.setAnswerStatus(answerStatusService.getByName(status));
        answerRepository.save(answer);
        return "Статус обновлён на " + answer.getAnswerStatus().getName();
    }

//    public List<AnswerDto> getAnswers(final Long answerId)
}
