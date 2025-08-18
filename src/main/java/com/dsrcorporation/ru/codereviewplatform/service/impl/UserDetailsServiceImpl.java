package com.dsrcorporation.ru.codereviewplatform.service.impl;

import com.dsrcorporation.ru.codereviewplatform.model.entity.Account;
import com.dsrcorporation.ru.codereviewplatform.repository.AccountRepository;
import com.dsrcorporation.ru.codereviewplatform.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Реализация {@link UserDetailsService}. Поиск аккаунта пользователя.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * Поиск аккаунта по имени.
     *
     * @param username имя аккаунта.
     * @return {@link UserDetailsImpl} данные об аккаунте.
     * @throws UsernameNotFoundException в случае, если пользователь не найден.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findByName(username);
        return account.map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("Аккаунт с ником '" + username + "' не найден."));
    }
}
