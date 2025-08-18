package com.dsrcorporation.ru.codereviewplatform.security;

import com.dsrcorporation.ru.codereviewplatform.model.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;


/**
 * Реализация {@link UserDetails}.
 */
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final Account account;

    /**
     * Получение роли.
     *
     * @return роль пользователя.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(
                new SimpleGrantedAuthority(account.getAccountRole().getName())
                );
    }

    /**
     * Получение пароля.
     *
     * @return пароль пользователя.
     */
    @Override
    public String getPassword() {
        return account.getPasswordHash();
    }

    /**
     * Получение имени
     * .
     * @return имя пользователя.
     */
    @Override
    public String getUsername() {
        return account.getName();
    }

    /**
     * Указывает, истек ли срок действия аккаунта пользователя.
     *
     * @return true по умолчанию (аккаунт действителен).
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Указывает, заблокирован ли аккаунт пользователя.
     *
     * @return true по умолчанию (аккаунт не заблокирован).
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Указывает, истек ли срок действия пароля.
     *
     * @return true по умолчанию (не истек).
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Включен ли аккаунт.
     *
     * @return true по умолчанию (включен).
     */
    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
