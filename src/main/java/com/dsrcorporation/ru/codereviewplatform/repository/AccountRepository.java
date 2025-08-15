package com.dsrcorporation.ru.codereviewplatform.repository;

import com.dsrcorporation.ru.codereviewplatform.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с аккаунтами пользователей.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
