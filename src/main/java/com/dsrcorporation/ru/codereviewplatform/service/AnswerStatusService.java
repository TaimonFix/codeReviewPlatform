package com.dsrcorporation.ru.codereviewplatform.service;

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
    public Long getIdByName(final String name) {
        return answerStatusRepository.getIdByName(name);
    }

    /**
     * Получить название статуса по id.
     *
     * @param id идентификатор статуса.
     * @return название статуса.
     */
    public String getNameById(final Long id) {
        return answerStatusRepository.getNameById(id);
    }
}
