package com.dsrcorporation.ru.codereviewplatform.service;

import com.dsrcorporation.ru.codereviewplatform.model.dto.FileDto;

import java.util.List;

/**
 * Сервис для работы с файлами.
 */
public interface FileService {

    /**
     * Сохранить файл
     *
     * @param fileDto данные о файле.
     * @return id файла.
     */
    Long saveFile(FileDto fileDto);

    /**
     * Получить файл по id.
     *
     * @param id идентификатор файла.
     * @return {@link FileDto} данные о файле.
     */
    FileDto getFile(Long id);

    /**
     * Получить все файлы.
     *
     * @return Список {@link FileDto} файлов.
     */
    List<FileDto> getFiles();

    /**
     * Получить файл по id ответа.
     *
     * @param answerId идентификатор ответа.
     * @return Список {@link FileDto} файлов.
     */
    List<FileDto> getFilesByAnswerId(Long answerId);

    /**
     * Удалить файл по id.
     *
     * @param id идентификатор файла.
     */
    void deleteFile(Long id);
}
