package com.dsrcorporation.ru.codereviewplatform.mapper;

import com.dsrcorporation.ru.codereviewplatform.model.dto.FileDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.File;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

/** Маппер для работы с {@link File}. */
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface FileMapper {

    FileDto toDto(File file);

    List<FileDto> toDtoList(List<File> files);
}
