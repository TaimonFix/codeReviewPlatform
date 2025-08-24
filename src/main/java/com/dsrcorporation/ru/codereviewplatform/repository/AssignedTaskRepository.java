package com.dsrcorporation.ru.codereviewplatform.repository;

import com.dsrcorporation.ru.codereviewplatform.model.entity.AssignedTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Репозиторий для работы с назначенными задачами.
 */
public interface AssignedTaskRepository extends JpaRepository<AssignedTask, Long> {

    /**
     * Найти все задачи по id аккаунта.
     *
     * @param accountId id аккаунта.
     * @return Список задач, назначенных конкретному аккаунту.
     */
    List<AssignedTask> findAllByAccountId(Long accountId);

    /**
     * Найти все задачи по id задачи.
     *
     * @param taskId id задачи.
     * @return Список аккаунтов, которым была назначена конкретная задача.
     */
    List<AssignedTask> findAllByTaskId(Long taskId);
}
