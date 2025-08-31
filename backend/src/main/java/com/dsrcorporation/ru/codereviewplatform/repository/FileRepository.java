package com.dsrcorporation.ru.codereviewplatform.repository;

import com.dsrcorporation.ru.codereviewplatform.model.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** Репозиторий для работы с {@link File}.*/
@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    /**
     * Получить все файлы по id ответа.
     *
     * @param answerId идентификатор ответа.
     * @return Список {@link File} файлов.
     */
    List<File> findAllByAnswerId(Long answerId);
}
