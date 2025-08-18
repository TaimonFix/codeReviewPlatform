package com.dsrcorporation.ru.codereviewplatform.controller;

import com.dsrcorporation.ru.codereviewplatform.model.dto.TaskDto;
import com.dsrcorporation.ru.codereviewplatform.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер для работы с задачами.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{accountId}")
    @PreAuthorize("hasRole('TEACHER')")
    public List<TaskDto> getTasks(@PathVariable Long accountId) {
        return taskService.getTasksByAccountId(accountId);
    }
}
