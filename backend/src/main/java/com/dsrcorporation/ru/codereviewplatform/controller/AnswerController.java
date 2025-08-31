package com.dsrcorporation.ru.codereviewplatform.controller;

import com.dsrcorporation.ru.codereviewplatform.model.dto.AnswerDto;
import com.dsrcorporation.ru.codereviewplatform.security.UserDetailsImpl;
import com.dsrcorporation.ru.codereviewplatform.service.AnswerService;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/** Контроллер для работы с {@link Answer}. */
@Controller
@RequiredArgsConstructor
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<Long> save(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                     @RequestBody AnswerDto answerDto) {
        return new ResponseEntity<>(
                answerService.save(answerDto, userDetails.getAccountId()),
                HttpStatus.CREATED);
    }

    @PatchMapping("/{answerId}/{status}")
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<String> updateAnswerStatus(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                     @PathVariable Long answerId, @PathVariable String status) {
        return new ResponseEntity<>(
                answerService.updateAnswerStatus(userDetails.getAccountId(), answerId, status),
                HttpStatus.CREATED);
    }
}
