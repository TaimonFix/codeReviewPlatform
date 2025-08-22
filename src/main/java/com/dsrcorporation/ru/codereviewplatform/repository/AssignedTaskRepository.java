package com.dsrcorporation.ru.codereviewplatform.repository;

import com.dsrcorporation.ru.codereviewplatform.model.entity.AssignedTask;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с назначенными задачами.
 */
public interface AssignedTaskRepository extends JpaRepository<AssignedTask, Long> {
}
