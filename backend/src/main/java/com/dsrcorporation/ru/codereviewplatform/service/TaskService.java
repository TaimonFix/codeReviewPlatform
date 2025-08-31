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

/** Сервис для работы с {@link Task}. */
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
    public Long save(final Long accountId, final TaskDto taskDto) {
        Account account = accountService.findById(accountId);
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
    public Task findById(final Long id) {
        return taskRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Задание с id '" + id + "' не найдено."));
    }

    /**
     * Проверка: является ли пользователь создателем задачи.
     *
     * @param accountId id пользователя.
     * @param taskId id задачи
     * @return true (если является).
     */
    public boolean isTaskCreator(final Long accountId, final Long taskId) {
        Task task = findById(taskId);
        return task.getAccount().getId().equals(accountId);
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
}
