package com.cheerup.cheerup.repository;

import com.cheerup.cheerup.model.Article;
import com.cheerup.cheerup.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByOrderByIdDesc();
    Page<Article> findAllByOrderByCreatedAtDesc(Pageable pageable);
    Optional<List<Article>> findAllById(Long id);
}
