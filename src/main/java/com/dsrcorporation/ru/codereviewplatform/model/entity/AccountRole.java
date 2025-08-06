package com.dsrcorporation.ru.codereviewplatform.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Роль пользователя.
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "account_role")
public class AccountRole {

    /**
     * Идентификатор роли.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Название роли.
     */
    @NotNull
    @Column(name = "name")
    private String name;
}
