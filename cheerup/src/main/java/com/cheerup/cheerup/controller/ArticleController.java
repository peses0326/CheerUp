package com.cheerup.cheerup.controller;

import com.cheerup.cheerup.dto.ArticleRequestDto;
import com.cheerup.cheerup.model.Article;
import com.cheerup.cheerup.repository.ArticleRepository;
import com.cheerup.cheerup.security.UserDetailsImpl;
import com.cheerup.cheerup.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {
    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    @GetMapping("/article")
    public List<Article> getArticle() {
        List<Article> articleList = articleRepository.findAllByOrderByCreatedAtDesc();
        return articleService.updateCounter(articleList);
    }

    @GetMapping("/article/{id}")
    public List<Article> getArticle(@PathVariable Long id) {
        List<Article> articleList = articleRepository.findAllById(id).orElseThrow(() -> new IllegalArgumentException("해당 Id가 존재하지 않습니다."));
        return articleService.updateCounter(articleList);
    }

    @PostMapping("/article")
    public Article createArticle(@RequestBody ArticleRequestDto requestDto) {
        return articleService.createArticle(requestDto);
    }

    @PutMapping("/article/{id}")
    public Long updateText(@PathVariable Long id, @RequestBody ArticleRequestDto requestDto) {
        articleService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/article/{id}")
    public Long deleteArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
        return id;
    }
}
