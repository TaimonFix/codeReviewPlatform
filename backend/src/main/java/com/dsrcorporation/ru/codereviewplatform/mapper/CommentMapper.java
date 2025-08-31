package com.dsrcorporation.ru.codereviewplatform.mapper;

import com.dsrcorporation.ru.codereviewplatform.model.dto.CommentDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Comment;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

/** Маппер для работы с {@link CommentMapper}. */
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CommentMapper {

    Comment toEntity(CommentDto commentDto);

    CommentDto toDto(Comment comment);

    List<CommentDto> toDtoList(List<Comment> comments);
}
