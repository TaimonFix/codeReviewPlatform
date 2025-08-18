package com.dsrcorporation.ru.codereviewplatform.repository;

import com.dsrcorporation.ru.codereviewplatform.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий для работы с аккаунтами пользователей.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * Поиск аккаунта по имени.
     *
     * @param name имя пользователя
     * @return данные об аккаунте
     */
    Optional<Account> findByName(String name);

    /**
     * Существует ли пользователь в БД.
     *
     * @param name имя пользователя.
     * @return true - существует, false - нет.
     */
    boolean existsByName(String name);
}
