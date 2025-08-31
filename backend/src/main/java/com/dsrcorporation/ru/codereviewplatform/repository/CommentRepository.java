package com.dsrcorporation.ru.codereviewplatform.repository;

import com.dsrcorporation.ru.codereviewplatform.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** Репозиторий для работы с {@link Comment}.*/
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByAnswerId(Long answerId);
}
