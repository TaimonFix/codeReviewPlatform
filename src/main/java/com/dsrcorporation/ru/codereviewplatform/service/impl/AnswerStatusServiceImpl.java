package com.dsrcorporation.ru.codereviewplatform.service.impl;

import com.dsrcorporation.ru.codereviewplatform.repository.AnswerStatusRepository;
import com.dsrcorporation.ru.codereviewplatform.service.AnswerStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Реализация {@link AnswerStatusService}.
 */
@Service
@RequiredArgsConstructor
public class AnswerStatusServiceImpl implements AnswerStatusService {

    private final AnswerStatusRepository answerStatusRepository;

    /**
     * Получить id статуса по названию.
     *
     * @param name название статуса.
     * @return id роли.
     */
    @Override
    public Long getIdByName(final String name) {
        return answerStatusRepository.getIdByName(name);
    }

    /**
     * Получить название статуса по id.
     *
     * @param id идентификатор статуса.
     * @return название статуса.
     */
    @Override
    public String getNameById(final Long id) {
        return answerStatusRepository.getNameById(id);
    }
}
