package com.dsrcorporation.ru.codereviewplatform.controller;

import com.dsrcorporation.ru.codereviewplatform.model.dto.AnswerDto;
import com.dsrcorporation.ru.codereviewplatform.security.UserDetailsImpl;
import com.dsrcorporation.ru.codereviewplatform.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер для работы с ответами.
 */
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
                answerService.save(answerDto, userDetails.getAccountId()), HttpStatus.CREATED);
    }
}
