package com.dsrcorporation.ru.codereviewplatform.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Ответ на задание.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Table(name = "answer")

public class Answer {

    /**
     * Идентификатор ответа.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "task_id", referencedColumnName = "task_id"),
            @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    })
    private AssignedTask assignedTask;
//    /**
//     * Аккаунт ученика, кто прислал ответ.
//     */
//    @NotNull
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "account_id")
//    private Account account;
//
//    /**
//     * Задание, на которое выслан ответ.
//     */
//    @NotNull
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "task_id")
//    private Task task;

    /**
     * Статус ответ на задания.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "answer_status_id")
    private AnswerStatus answerStatus;
}
