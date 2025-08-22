package com.dsrcorporation.ru.codereviewplatform.controller;

import com.dsrcorporation.ru.codereviewplatform.model.dto.TaskDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Account;
import com.dsrcorporation.ru.codereviewplatform.security.UserDetailsImpl;
import com.dsrcorporation.ru.codereviewplatform.service.TaskService;
import lombok.RequiredArgsConstructor;
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
    public List<TaskDto> getTasks(@AuthenticationPrincipal UserDetailsImpl user) {
        return taskService.getTasksByAccountId(user.getAccountId());
    }

    @PostMapping
    @PreAuthorize("hasRole('TEACHER')")
    public Long saveTask(@AuthenticationPrincipal UserDetailsImpl user, @RequestBody TaskDto taskDto) {
        return taskService.save(user.getAccountId(), taskDto);
    }
}
