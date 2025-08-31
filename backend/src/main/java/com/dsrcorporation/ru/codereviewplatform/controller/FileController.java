package com.dsrcorporation.ru.codereviewplatform.controller;

import com.dsrcorporation.ru.codereviewplatform.model.dto.FileDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.File;
import com.dsrcorporation.ru.codereviewplatform.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/** Контроллер для работы с {@link File}. */
@Controller
@RequiredArgsConstructor
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    @PostMapping("/{answerId}")
    public ResponseEntity<String> upload(@PathVariable("answerId") Long answerId,
                                         @RequestParam("zip") MultipartFile zip) {
        return new ResponseEntity<>(fileService.upload(answerId, zip), HttpStatus.CREATED);
    }

    @GetMapping("/{fileId}/download")
    public ResponseEntity<FileDto> download(@PathVariable("fileId") Long fileId) {
        return new ResponseEntity<>(fileService.findById(fileId), HttpStatus.OK);
    }

    @GetMapping("/{answerId}")
    public ResponseEntity<List<FileDto>> getFiles(@PathVariable("answerId") Long answerId) {
        return new ResponseEntity<>(fileService.findAllByAnswerId(answerId), HttpStatus.OK);
    }
}
