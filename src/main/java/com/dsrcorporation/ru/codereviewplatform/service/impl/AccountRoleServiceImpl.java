package com.dsrcorporation.ru.codereviewplatform.service.impl;

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
     * Получить id роли по названию.
     *
     * @param name название роли.
     * @return id роли.
     */
    @Override
    public Long getIdByName(final String name) {
        return accountRoleRepository.getIdByName(name);
    }

    /**
     * Получить название роли по id.
     *
     * @param id идентификатор роли.
     * @return название роли.
     */
    @Override
    public String getNameById(final Long id) {
        return accountRoleRepository.getNameById(id);
    }
}
