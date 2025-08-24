package com.dsrcorporation.ru.codereviewplatform.service;

import com.dsrcorporation.ru.codereviewplatform.mapper.AssignedTaskMapper;
import com.dsrcorporation.ru.codereviewplatform.model.dto.AssignedTaskDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.AssignedTask;
import com.dsrcorporation.ru.codereviewplatform.model.entity.AssignedTaskId;
import com.dsrcorporation.ru.codereviewplatform.repository.AssignedTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с назначенными задачами.
 */
@Service
@RequiredArgsConstructor
public class AssignedTaskService {

    private final AssignedTaskRepository assignedTaskRepository;
    private final AssignedTaskMapper assignedTaskMapper;
    private final TaskService taskService;
    private final AccountService accountService;

    public AssignedTaskDto save(AssignedTaskDto assignedTaskDto) {
        AssignedTask assignedTask = AssignedTask.builder()
                                .assignedTaskId(new AssignedTaskId(
                                        assignedTaskDto.getTaskId(), assignedTaskDto.getAccountId()))
                                .task(taskService.getTaskById(assignedTaskDto.getTaskId()))
                                .account(accountService.getAccountById(assignedTaskDto.getAccountId()))
                                .build();
        return assignedTaskMapper.toDto(assignedTaskRepository.save(assignedTask));
    }


    public List<AssignedTaskDto> getAssignedTasksByAccountId(Long accountId) {
        return assignedTaskMapper.toDtoList(assignedTaskRepository.findAllByAccountId(accountId));
    }

    public List<AssignedTaskDto> getAssignedTasksByTaskId(Long taskId) {
        return assignedTaskMapper.toDtoList(assignedTaskRepository.findAllByTaskId(taskId));
    }
}
