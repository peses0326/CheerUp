package com.cheerup.cheerup.controller;

import com.cheerup.cheerup.dto.ArticleRequestDto;
import com.cheerup.cheerup.dto.CommentPageRequestDto;
import com.cheerup.cheerup.model.Article;
import com.cheerup.cheerup.repository.ArticleRepository;
import com.cheerup.cheerup.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {
    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    @GetMapping("/article")
    public List<Article> getArticle(@RequestParam(value = "username", required = false, defaultValue = "") String username) {
        List<Article> articleList = articleRepository.findAllByOrderByIdDesc();
        return articleService.likeItBoolean(articleList, username);
    }

    @GetMapping("/article/page") // Get 방식 게시글 전체 조회
    public Page<Article> readPagedAritclesByGetMapping(@RequestParam("page") int page, @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return articleService.pagedUpdateCounter(articleRepository.findAllByOrderByCreatedAtDesc(pageable));
    }

    @PostMapping("/article/page") // Post 방식 게시글 전체 조회
    public Page<Article> readPagedArticlesByPostMapping(@RequestBody CommentPageRequestDto requestDto) {
        Pageable pageable = PageRequest.of(requestDto.getPage() - 1, requestDto.getSize());
        return articleService.pagedUpdateCounter(articleRepository.findAllByOrderByCreatedAtDesc(pageable));
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
