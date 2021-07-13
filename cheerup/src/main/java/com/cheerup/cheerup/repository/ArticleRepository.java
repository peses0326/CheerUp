package com.cheerup.cheerup.repository;

import com.cheerup.cheerup.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByOrderByCreatedAtDesc();
    Optional<List<Article>> findAllById(Long id);
}
