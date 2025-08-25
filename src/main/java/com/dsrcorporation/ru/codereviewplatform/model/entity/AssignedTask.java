package com.dsrcorporation.ru.codereviewplatform.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Назначенная задача.
 */
@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@Table(name = "assigned_task")
@AllArgsConstructor
public class AssignedTask {

    /**
     * Составной ключ.
     */
    @EmbeddedId
    private AssignedTaskId assignedTaskId;

    /**
     * Задача.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("taskId")
    @JoinColumn(name = "task_id")
    private Task task;

    /**
     * Пользователь, которому назначена задача.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("accountId")
    @JoinColumn(name = "account_id")
    private Account account;
}
