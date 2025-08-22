package com.dsrcorporation.ru.codereviewplatform.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Назначенная задача.
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "assigned_task")
public class AssignedTask {

    /**
     * Идентификатор назначенной задачи.
     */
    @Id
    private Long id;

    /**
     * Задача.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    private Task task;

    /**
     * Пользователь, которому назначена задача.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;
}
