package com.dsrcorporation.ru.codereviewplatform.controller;

import com.dsrcorporation.ru.codereviewplatform.model.dto.AssignedTaskDto;

import com.dsrcorporation.ru.codereviewplatform.security.UserDetailsImpl;
import com.dsrcorporation.ru.codereviewplatform.service.AssignedTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Контроллер для работы с назначенными задачами.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/assigned-tasks")
public class AssignedTaskController {

    private final AssignedTaskService assignedTaskService;

    // TODO: добавить возможность за раз назначать нескольким студентам задание.
    @PostMapping
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<AssignedTaskDto> save(@RequestBody AssignedTaskDto assignedTaskDto) {
        return new ResponseEntity<>(assignedTaskService.save(assignedTaskDto), HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<List<AssignedTaskDto>> getAssignedTasks(
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return new ResponseEntity<>(
                assignedTaskService.getAssignedTasksByAccountId(userDetails.getAccountId()),
                HttpStatus.OK);
    }
}
