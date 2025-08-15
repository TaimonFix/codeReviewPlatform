package com.dsrcorporation.ru.codereviewplatform.service;

import com.dsrcorporation.ru.codereviewplatform.model.dto.CommentDto;

import java.util.List;

/**
 * Сервис для работы с комментариями.
 */
public interface CommentService {

    /**
     * Сохранить комментарий.
     *
     * @param commentDto данные о комментарии.
     * @return id комментария.
     */
    Long saveComment(CommentDto commentDto);

    /**
     * Получить комментарии по id ответа.
     *
     * @param answerId id ответа.
     *
     * @return Список {@link CommentDto} комментариев.
     */
    List<CommentDto> getCommentsByAnswerId(Long answerId);

    /**
     * Удалить комментарий.
     *
     * @param id идентификатор комментария.
     */
    void deleteComment(Long id);
}
