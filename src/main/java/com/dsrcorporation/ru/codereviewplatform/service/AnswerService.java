package com.dsrcorporation.ru.codereviewplatform.service;

import com.dsrcorporation.ru.codereviewplatform.model.dto.AnswerDto;

import java.util.List;

/**
 * Сервис для работы с ответами.
 */
public interface AnswerService {

    /**
     * Сохранить ответ.
     *
     * @param answerDto данные об ответе.
     * @return id ответа.
     */
    Long saveAnswer(AnswerDto answerDto);

    /**
     * Получить ответы по заданию.
     *
     * @param taskId идентификатор задания.
     * @return Список {@link AnswerDto} ответов.
     */
    List<AnswerDto> getAnswersByTaskId(Long taskId);

    /**
     * Удалить ответ.
     *
     * @param id идентификатор ответа.
     */
    void deleteAnswer(Long id);

}
