package com.dsrcorporation.ru.codereviewplatform.controller;

import com.dsrcorporation.ru.codereviewplatform.model.dto.CommentDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Comment;
import com.dsrcorporation.ru.codereviewplatform.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Контроллер для работы с {@link Comment}. */
@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.save(commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{answerId}")
    public ResponseEntity<List<CommentDto>> findByAnswerId(@PathVariable Long answerId) {
        return new ResponseEntity<>(commentService.findAllByAnswerId(answerId), HttpStatus.OK);
    }
}
