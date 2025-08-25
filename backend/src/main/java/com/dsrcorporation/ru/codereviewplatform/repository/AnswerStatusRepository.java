package com.dsrcorporation.ru.codereviewplatform.repository;

import com.dsrcorporation.ru.codereviewplatform.model.entity.AccountRole;
import com.dsrcorporation.ru.codereviewplatform.model.entity.AnswerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий для работы со статусами ответов.
 */
@Repository
public interface AnswerStatusRepository extends JpaRepository<AnswerStatus, Long> {

    /**
     * Получить статус по названию.
     *
     * @param name название статуса.
     * @return {@link Optional} {@link AnswerStatus} данные о роли.
     */
    Optional<AnswerStatus> getByName(String name);
}
