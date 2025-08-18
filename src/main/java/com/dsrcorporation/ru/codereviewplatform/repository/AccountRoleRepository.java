package com.dsrcorporation.ru.codereviewplatform.repository;

import com.dsrcorporation.ru.codereviewplatform.model.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий для работы с ролями пользователей.
 */
@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {

    Optional<AccountRole> getByName(String name);
}
