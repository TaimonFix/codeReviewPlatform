package com.dsrcorporation.ru.codereviewplatform.service;

import com.dsrcorporation.ru.codereviewplatform.exception.EntityNotFoundException;
import com.dsrcorporation.ru.codereviewplatform.mapper.FileMapper;
import com.dsrcorporation.ru.codereviewplatform.model.dto.FileDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Answer;
import com.dsrcorporation.ru.codereviewplatform.model.entity.File;
import com.dsrcorporation.ru.codereviewplatform.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/** Сервис для работы с {@link File}. */
@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;
    private final FileMapper fileMapper;
    private final AnswerService answerService;
    private final Path STORAGE_DIR = Paths.get("data");


    public String upload(final Long answerId, final MultipartFile zip) {
        Answer answer = answerService.findById(answerId);
        try (ZipInputStream zis = new ZipInputStream(zip.getInputStream())) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String extension = entry.getName().contains(".")
                        ? entry.getName().substring(entry.getName().lastIndexOf("."))
                        : "";
                String localPath = UUID.randomUUID().toString() + extension;
                if (!entry.isDirectory()) {
                    Path filePath = STORAGE_DIR.resolve(entry.getName());
                    Files.createDirectories(filePath.getParent());

                    try (OutputStream os = Files.newOutputStream(filePath)) {
                        zis.transferTo(os);
                    }
                    File file = File.builder()
                            .filePath(entry.getName())
                            .localPath(STORAGE_DIR + "/" + localPath)
                            .answer(answer)
                            .build();
                    fileRepository.save(file);
                }
            }
            return "Файл сохранен.";
        } catch (IOException e) {
            return "Произошла ошибка при сохранении файла.";
        }
    }

    public FileDto findById(final Long id) {
        return fileMapper.toDto(fileRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Файл и id '" + id + "' не найден.")));
    }

    public List<FileDto> findAllByAnswerId(final Long answerId) {
        return fileMapper.toDtoList(fileRepository.findAllByAnswerId(answerId));
    }
}
