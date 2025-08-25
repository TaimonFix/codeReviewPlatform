package com.dsrcorporation.ru.codereviewplatform.service;

import com.dsrcorporation.ru.codereviewplatform.exception.EntityNotFoundException;
import com.dsrcorporation.ru.codereviewplatform.model.entity.AnswerStatus;
import com.dsrcorporation.ru.codereviewplatform.repository.AnswerStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы со статусами ответов.
 */
@Service
@RequiredArgsConstructor
public class AnswerStatusService {

    private final AnswerStatusRepository answerStatusRepository;

    /**
     * Получить id статуса по названию.
     *
     * @param name название статуса.
     * @return id роли.
     */
    public AnswerStatus getByName(final String name) {
        return answerStatusRepository.getByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Роль '" + name + "' не найдена."));
    }
}
