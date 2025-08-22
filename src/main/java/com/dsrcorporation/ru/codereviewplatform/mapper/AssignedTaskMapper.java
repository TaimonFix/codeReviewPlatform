package com.dsrcorporation.ru.codereviewplatform.mapper;

import com.dsrcorporation.ru.codereviewplatform.model.dto.AssignedTaskDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.AssignedTask;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AssignedTaskMapper {

    AssignedTask toEntity(AssignedTaskDto assignedTaskDto);

    AssignedTaskDto toDto(AssignedTask assignedTask);
}
