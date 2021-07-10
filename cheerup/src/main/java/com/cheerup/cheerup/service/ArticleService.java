package com.cheerup.cheerup.service;

import com.cheerup.cheerup.dto.ArticleRequestDto;
import com.cheerup.cheerup.model.Article;
import com.cheerup.cheerup.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Article createArticle(ArticleRequestDto requestDto, String username) {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Article article = new Article(requestDto, username);
        articleRepository.save(article);
        return article;
    }

    @GetMapping("/api/article/{id}")
    public Article getArticle(@PathVariable Long id) {
        Article article =  articleRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException(" "));
        return article;
    }
}
