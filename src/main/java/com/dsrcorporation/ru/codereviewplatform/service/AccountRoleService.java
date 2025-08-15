package com.dsrcorporation.ru.codereviewplatform.service;

/**
 * Сервис для работы с ролями пользователей.
 */
public interface AccountRoleService {

    /**
     * Получить id роли по названию.
     *
     * @param name название роли.
     * @return id роли.
     */
    Long getIdByName(String name);

    /**
     * Получить название роли по id.
     *
     * @param id идентификатор роли.
     * @return название роли.
     */
    String getNameById(Long id);
}
