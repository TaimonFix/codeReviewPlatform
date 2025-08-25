package com.dsrcorporation.ru.codereviewplatform.repository;

import com.dsrcorporation.ru.codereviewplatform.model.dto.TaskDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы с заданиями.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Получить все задачи по id пользователя.
     *
     * @param accountId идентификатор пользователя.
     * @return Список {@link Task} задач.
     */
    List<Task> findAllByAccountId(Long accountId);
}
