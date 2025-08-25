package com.dsrcorporation.ru.codereviewplatform.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Метаданные о файле, который прислал пользователь.
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "file")
public class File {

    /**
     * Идентификатор файла.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Исходный путь к файлу.
     */
    @NotNull
    @Column(name = "file_path")
    private String filePath;

    /**
     * Путь файла на сервере.
     */
    @NotNull
    @Column(name = "local_path")
    private String localPath;

    /**
     * Задание, для которого был прислан файл.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;
}
