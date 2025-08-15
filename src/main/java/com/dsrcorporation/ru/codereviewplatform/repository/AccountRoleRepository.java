package com.dsrcorporation.ru.codereviewplatform.repository;

import com.dsrcorporation.ru.codereviewplatform.model.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с ролями пользователей.
 */
@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {

    /**
     * Получить id роли по названию.
     *
     * @param name название роли.
     * @return id роли.
     */
    Long getIdByName(String name);

    /**
     * Получить название роли по id.
     *
     * @param id идентификатор роли.
     * @return название роли.
     */
    String getNameById(Long id);
}
