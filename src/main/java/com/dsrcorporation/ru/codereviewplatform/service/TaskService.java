package com.dsrcorporation.ru.codereviewplatform.service;

import com.dsrcorporation.ru.codereviewplatform.model.dto.TaskDto;

import java.util.List;

/**
 * Сервис для работы с заданиями.
 */
public interface TaskService {

    /**
     * Сохранить задание.
     *
     * @param taskDto данные о задании.
     * @return id задания.
     */
    Long saveTask(TaskDto taskDto);

    /**
     * Получить задачу по id.
     *
     * @param id идентификатор задачи
     * @return {@link TaskDto} данные о задаче.
     */
    TaskDto getTaskById(Long id);

    /**
     * Получить все задачи.
     *
     * @return Список {@link TaskDto} задач.
     */
    List<TaskDto> getTasks();

    /**
     * Получить все задачи по id пользователя.
     *
     * @param accountId идентификатор пользователя.
     * @return Список {@link TaskDto} задач.
     */
    List<TaskDto> getTasksByAccountId(Long accountId);

    /**
     * Удалить задачу.
     *
     * @param id идентификатор задачи
     */
    void deleteTask(Long id);
}
