package com.dsrcorporation.ru.codereviewplatform.service;

import com.dsrcorporation.ru.codereviewplatform.model.entity.AccountRole;

/**
 * Сервис для работы с ролями пользователей.
 */
public interface AccountRoleService {

    /**
     * Получить {@link AccountRole} по названию.
     *
     * @param name название роли.
     * @return {@link AccountRole}.
     */
    AccountRole getByName(final String name);
}
