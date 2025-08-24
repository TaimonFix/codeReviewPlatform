package com.dsrcorporation.ru.codereviewplatform.mapper;

import com.dsrcorporation.ru.codereviewplatform.model.dto.AssignedTaskDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.AssignedTask;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AssignedTaskMapper {

    AssignedTask toEntity(AssignedTaskDto assignedTaskDto);

    @Mapping(target = "taskId", source = "task.id")
    @Mapping(target = "accountId", source = "account.id")
    AssignedTaskDto toDto(AssignedTask assignedTask);

    List<AssignedTaskDto> toDtoList(List<AssignedTask> assignedTaskList);
}
