package com.dsrcorporation.ru.codereviewplatform.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO - задание от преподавателя.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private String name;
    private String description;
}
