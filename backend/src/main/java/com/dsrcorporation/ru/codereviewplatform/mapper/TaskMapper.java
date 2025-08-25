package com.dsrcorporation.ru.codereviewplatform.mapper;

import com.dsrcorporation.ru.codereviewplatform.model.dto.TaskDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Task;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Маппер для работы с заданиями.
 */
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TaskMapper {

    TaskDto toDto(Task task);

    Task toEntity(TaskDto taskDto);

    List<TaskDto> toDtoList(List<Task> taskList);
}
