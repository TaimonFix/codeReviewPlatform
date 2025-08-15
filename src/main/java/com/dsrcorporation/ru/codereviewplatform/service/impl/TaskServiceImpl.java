package com.dsrcorporation.ru.codereviewplatform.service.impl;

import com.dsrcorporation.ru.codereviewplatform.exception.EntityNotFoundException;
import com.dsrcorporation.ru.codereviewplatform.mapper.TaskMapper;
import com.dsrcorporation.ru.codereviewplatform.model.dto.TaskDto;
import com.dsrcorporation.ru.codereviewplatform.repository.TaskRepository;
import com.dsrcorporation.ru.codereviewplatform.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Реализация {@link TaskService}.
 */
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    /**
     * Сохранить задание.
     *
     * @param taskDto данные о задании.
     * @return id задания.
     */
    @Override
    public Long saveTask(TaskDto taskDto) {
        return taskRepository.save(taskMapper.toEntity(taskDto)).getId();
    }

    /**
     * Получить задачу по id.
     *
     * @param id идентификатор задачи
     * @return {@link TaskDto} данные о задаче.
     */
    @Override
    public TaskDto getTask(Long id) {
        return taskMapper.toDto(taskRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Задание с id '" + id + "' не найдено.")));
    }

    /**
     * Получить все задачи.
     *
     * @return Список {@link TaskDto} задач.
     */
    @Override
    public List<TaskDto> getTasks() {
        return taskMapper.toDtoList(taskRepository.findAll());
    }

    /**
     * Получить все задачи по id пользователя.
     *
     * @param accountId идентификатор пользователя.
     * @return Список {@link TaskDto} задач.
     */
    @Override
    public List<TaskDto> getTasksByAccountId(Long accountId) {
        return taskMapper.toDtoList(taskRepository.findAllByAccountId(accountId));
    }

    /**
     * Удалить задачу.
     *
     * @param id идентификатор задачи
     */
    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
