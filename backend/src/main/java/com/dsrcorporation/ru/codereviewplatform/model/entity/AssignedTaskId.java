package com.dsrcorporation.ru.codereviewplatform.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

/**
 * Композитный ключ таблицы 'assigned-task'
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class AssignedTaskId implements Serializable {

    @NotNull
    @Column(name = "task_id")
    private Long taskId;
    @NotNull
    @Column(name = "account_id")
    private Long accountId;
}
