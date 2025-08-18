package com.dsrcorporation.ru.codereviewplatform.service.impl;

import com.dsrcorporation.ru.codereviewplatform.exception.EntityNotFoundException;
import com.dsrcorporation.ru.codereviewplatform.mapper.AccountMapper;
import com.dsrcorporation.ru.codereviewplatform.model.dto.AccountDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Account;
import com.dsrcorporation.ru.codereviewplatform.model.entity.AccountRole;
import com.dsrcorporation.ru.codereviewplatform.repository.AccountRepository;
import com.dsrcorporation.ru.codereviewplatform.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Реализация {@link AccountService}.
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;

    /**
     * @param accountDto аккаунт пользователя.
     * @return id аккаунта.
     */
    @Override
    public Long saveAccount(AccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);
        account.setAccountRole(new AccountRole());
        return accountRepository.save(account).getId();
    }

    /**
     * Получить аккаунт по id.
     *
     * @param id идентификатор аккаунта.
     * @return {@link AccountDto} аккаунт пользователя.
     * @throws EntityNotFoundException в случае, если аккаунта нет в БД.
     */
    @Override
    public AccountDto getAccountById(Long id) {
        return accountMapper.toDto(accountRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Аккаунт с id '" + id + "' не найден.")));
    }
}
