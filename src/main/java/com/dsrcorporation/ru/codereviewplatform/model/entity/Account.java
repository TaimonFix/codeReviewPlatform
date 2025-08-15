package com.dsrcorporation.ru.codereviewplatform.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Аккаунт пользователя.
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "account")
public class Account {

    /**
     * Идентификатор аккаунта.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Имя пользователя.
     */
    @NotNull
    @Column(name = "name")
    private String name;

    /**
     * Хэш пароля.
     */
    @NotNull
    @Column(name = "password_hash")
    private String passwordHash;

    /**
     * Роль пользователя.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_role_id")
    private AccountRole accountRole;
}
