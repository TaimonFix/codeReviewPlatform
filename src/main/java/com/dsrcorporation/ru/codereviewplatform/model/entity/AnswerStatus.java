package com.dsrcorporation.ru.codereviewplatform.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Статус ответа на задание.
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "answer_status")
public class AnswerStatus {

    /**
     * Идентификатор статуса.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Название статуса.
     */
    @NotNull
    @Column(name = "name")
    private String name;
}
