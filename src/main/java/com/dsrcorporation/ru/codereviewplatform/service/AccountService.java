package com.dsrcorporation.ru.codereviewplatform.service;

import com.dsrcorporation.ru.codereviewplatform.model.dto.AccountDto;

/**
 * Сервис для работы с аккаунтами пользователей.
 */
public interface AccountService {
    /**
     *
     * @param accountDto аккаунт пользователя.
     * @return id аккаунта.
     */
    Long saveAccount(AccountDto accountDto);

    /**
     * Получить аккаунт по id.
     *
     * @param id идентификатор аккаунта.
     * @return {@link AccountDto} аккаунт пользователя.
     */
    AccountDto getAccount(Long id);
}
