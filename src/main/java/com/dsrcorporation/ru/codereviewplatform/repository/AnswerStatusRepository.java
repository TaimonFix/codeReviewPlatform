package com.dsrcorporation.ru.codereviewplatform.repository;

import com.dsrcorporation.ru.codereviewplatform.model.entity.AnswerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы со статусами ответов.
 */
@Repository
public interface AnswerStatusRepository extends JpaRepository<AnswerStatus, Long> {

    /**
     * Получить id статуса по названию.
     *
     * @param name название статуса.
     * @return id роли.
     */
    Long getIdByName(String name);

    /**
     * Получить название статуса по id.
     *
     * @param id идентификатор статуса.
     * @return название статуса.
     */
    String getNameById(Long id);
}
