package com.dsrcorporation.ru.codereviewplatform.service;

/**
 * Сервис для работы со статусами ответов.
 */
public interface AnswerStatusService {

    /**
     * Получить id статуса по названию.
     *
     * @param name название статуса.
     * @return id роли.
     */
    Long getIdByName(String name);

    /**
     * Получить название статуса по id.
     *
     * @param id идентификатор статуса.
     * @return название статуса.
     */
    String getNameById(Long id);
}
