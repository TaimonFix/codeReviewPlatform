package com.dsrcorporation.ru.codereviewplatform.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO - комментарий.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private String text;
    private Long accountId;
    private Long answerId;
    private Long fileId;
    private Integer lineNumber;
}
