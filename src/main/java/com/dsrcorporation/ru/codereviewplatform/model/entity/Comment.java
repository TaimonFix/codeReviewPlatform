package com.dsrcorporation.ru.codereviewplatform.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

/**
 * Комментарий.
 * Пользователь может оставить комментарий:
 * 1. к конкретной строке в файле;
 * 2. к конкретному файлу;
 * 3. ко всему ответу.
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "comment")
public class Comment {

    /**
     * Идентификатор комментария.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Текст комментария.
     */
    @NotNull
    @Column(name = "text")
    private String text;

    /**
     * Время отправки комментария.
     */
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    /**
     * Аккаунт пользователя, кто прислал комментарий.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    /**
     * Ответ, на который прислан комментарий.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    /**
     * Файл, на который прислан комментарий.
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "file_id")
    private File file;

    /**
     * Строка в файле, на который был оставлен комментарий.
     */
    @Column(name = "line_number")
    private Integer lineNumber;
}
