package com.dsrcorporation.ru.codereviewplatform.controller;

import com.dsrcorporation.ru.codereviewplatform.model.dto.TaskDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Account;
import com.dsrcorporation.ru.codereviewplatform.security.UserDetailsImpl;
import com.dsrcorporation.ru.codereviewplatform.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для работы с задачами.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<List<TaskDto>> getTasks(@AuthenticationPrincipal UserDetailsImpl user) {
        return new ResponseEntity<>(taskService.getTasksByAccountId(user.getAccountId()), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<Long> save(@AuthenticationPrincipal UserDetailsImpl user, @RequestBody TaskDto taskDto) {
        return new ResponseEntity<>(taskService.save(user.getAccountId(), taskDto), HttpStatus.CREATED);
    }
}
