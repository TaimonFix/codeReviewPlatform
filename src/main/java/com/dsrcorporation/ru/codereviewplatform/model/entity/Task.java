package com.dsrcorporation.ru.codereviewplatform.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Задача, сформированная преподавателем.
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "task")
public class Task {

    /**
     * Идентификатор задачи.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Название задачи.
     */
    @NotNull
    @Column(name = "name")
    private String name;

    /**
     * Описание задачи.
     */
    @NotNull
    @Column(name = "description")
    private String description;

    /**
     * Аккаунт пользователя, который создал таск.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;
}
