package com.dsrcorporation.ru.codereviewplatform.service.impl;

import com.dsrcorporation.ru.codereviewplatform.exception.EntityNotFoundException;
import com.dsrcorporation.ru.codereviewplatform.model.entity.AccountRole;
import com.dsrcorporation.ru.codereviewplatform.repository.AccountRoleRepository;
import com.dsrcorporation.ru.codereviewplatform.service.AccountRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Реализация {@link AccountRoleService}.
 */
@Service
@RequiredArgsConstructor
public class AccountRoleServiceImpl implements AccountRoleService {

    private final AccountRoleRepository accountRoleRepository;

    /**
     * Получить {@link AccountRole} по названию.
     *
     * @param name название роли.
     * @return {@link AccountRole}.
     */
    @Override
    public AccountRole getByName(final String name) {
        return accountRoleRepository.getByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Роль '" + name + "' не найдена."));
    }
}
