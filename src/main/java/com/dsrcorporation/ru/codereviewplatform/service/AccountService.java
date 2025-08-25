package com.dsrcorporation.ru.codereviewplatform.service;

import com.dsrcorporation.ru.codereviewplatform.exception.EntityNotFoundException;
import com.dsrcorporation.ru.codereviewplatform.exception.EntityAlreadyExistsException;
import com.dsrcorporation.ru.codereviewplatform.mapper.AccountMapper;
import com.dsrcorporation.ru.codereviewplatform.model.dto.AccountDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Account;
import com.dsrcorporation.ru.codereviewplatform.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы с аккаунтами.
 */
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountRoleService accountRoleService;
    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;

    /**
     * @param accountDto аккаунт пользователя.
     * @return id аккаунта.
     */
    public Long save(AccountDto accountDto) {
        if (accountRepository.existsByName(accountDto.getName())) {
            throw new EntityAlreadyExistsException(
                    "Пользователь с именем '" + accountDto.getName() + "' уже существует.");
        }
        Account account = accountMapper.toEntity(accountDto);
        account.setAccountRole(accountRoleService.getByName(accountDto.getRole()));
        account.setPasswordHash(passwordEncoder.encode(accountDto.getPassword()));
        return accountRepository.save(account).getId();
    }

    /**
     * Получить аккаунт по id.
     *
     * @param id идентификатор аккаунта.
     * @return {@link Account} аккаунт пользователя.
     * @throws EntityNotFoundException в случае, если аккаунта нет в БД.
     */
    public Account getById(final Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Аккаунт с id '" + id + "' не найден."));
    }
}
