package com.dsrcorporation.ru.codereviewplatform.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO - ответ на задание от ученика.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {
    private Long accountId;
    private Long taskId;
}
