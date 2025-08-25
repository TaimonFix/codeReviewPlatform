package com.dsrcorporation.ru.codereviewplatform.service;

import com.dsrcorporation.ru.codereviewplatform.exception.EntityNotFoundException;
import com.dsrcorporation.ru.codereviewplatform.mapper.TaskMapper;
import com.dsrcorporation.ru.codereviewplatform.model.dto.TaskDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Account;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Task;
import com.dsrcorporation.ru.codereviewplatform.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервис для работы с задачами.
 */
@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final AccountService accountService;
    private final TaskMapper taskMapper;

    /**
     * Сохранить задание.
     *
     * @param accountId идентификатор аккаунта.
     * @param taskDto данные о задании.
     * @return id задания.
     */
    public Long save(Long accountId, TaskDto taskDto) {
        Account account = accountService.getById(accountId);
        Task task = taskMapper.toEntity(taskDto);
        task.setAccount(account);
        return taskRepository.save(task).getId();
    }

    /**
     * Получить задачу по id.
     *
     * @param id идентификатор задачи
     * @return {@link TaskDto} данные о задаче.
     * @throws EntityNotFoundException в случае, если задачи нет в БД.
     */
    public Task getTaskById(final Long id) {
        return taskRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Задание с id '" + id + "' не найдено."));
    }

    /**
     * Получить все задачи.
     *
     * @return Список {@link TaskDto} задач.
     */
    public List<TaskDto> getTasks() {
        return taskMapper.toDtoList(taskRepository.findAll());
    }

    /**
     * Получить все задачи по id пользователя.
     *
     * @param accountId идентификатор пользователя.
     * @return Список {@link TaskDto} задач.
     */
    public List<TaskDto> getTasksByAccountId(final Long accountId) {
        return taskMapper.toDtoList(taskRepository.findAllByAccountId(accountId));
    }

    // TODO: Добавить проверку: удалять можно только свои задачи.
    /**
     * Удалить задачу.
     *
     * @param id идентификатор задачи
     */
    public void deleteTask(final Long id) {
        taskRepository.deleteById(id);
    }
}
