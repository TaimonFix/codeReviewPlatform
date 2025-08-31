package com.dsrcorporation.ru.codereviewplatform.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Метаданные о файле, который прислал пользователь.
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@Table(name = "file")
@AllArgsConstructor
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
    @Column(name = "local_path", unique = true)
    private String localPath;

    /**
     * Задание, для которого был прислан файл.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;
}
