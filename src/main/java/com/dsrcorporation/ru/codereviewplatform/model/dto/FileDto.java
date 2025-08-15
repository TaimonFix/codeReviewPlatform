package com.dsrcorporation.ru.codereviewplatform.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * DTO - файл.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {
    private MultipartFile file;
    private String name;
    private Long answerId;
}
