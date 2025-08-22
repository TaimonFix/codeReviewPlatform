package com.dsrcorporation.ru.codereviewplatform.service;

import com.dsrcorporation.ru.codereviewplatform.exception.EntityNotFoundException;
import com.dsrcorporation.ru.codereviewplatform.model.entity.AccountRole;
import com.dsrcorporation.ru.codereviewplatform.repository.AccountRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы с ролями аккаунтов.
 */
@Service
@RequiredArgsConstructor
public class AccountRoleService {

    private final AccountRoleRepository accountRoleRepository;

    /**
     * Получить {@link AccountRole} по названию.
     *
     * @param name название роли.
     * @return {@link AccountRole}.
     */
    public AccountRole getByName(final String name) {
        return accountRoleRepository.getByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Роль '" + name + "' не найдена."));
    }
}
