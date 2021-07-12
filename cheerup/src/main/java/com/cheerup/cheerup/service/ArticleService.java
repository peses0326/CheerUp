package com.cheerup.cheerup.service;

import com.cheerup.cheerup.dto.ArticleRequestDto;
import com.cheerup.cheerup.model.Article;
import com.cheerup.cheerup.model.Ip;
import com.cheerup.cheerup.repository.ArticleRepository;
import com.cheerup.cheerup.repository.CommentRepository;
import com.cheerup.cheerup.repository.IpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final IpRepository ipRepository;

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Article createArticle(ArticleRequestDto requestDto, String username) {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Article article = new Article(requestDto, username);
        articleRepository.save(article);
        return article;
    }

    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable Long id) {
        return articleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(" "));
    }

    public List<Article> commentsCounter(List<Article> articleList) {
        for (Article value : articleList) {
            Optional<Article> articleOptional = Optional.ofNullable(value);
            if (articleOptional.isPresent()) {
                Article article = articleOptional.get();
                Long articleId = article.getId();
                Long commentsCount = commentRepository.countByArticleId(articleId);
                article.addCommentsCount(commentsCount);
            }
        }
        return articleList;
    }

    @Transactional
    public Ip IpChecker() {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String visitorIp = req.getHeader("X-FORWARDED-FOR");
        if (visitorIp == null)
            visitorIp = req.getRemoteAddr();
        Ip ip = new Ip(visitorIp);
        List<Ip> IpList = ipRepository.findAll();
        if (IpList.contains(ip)) {
            ipRepository.save(ip);
            return ip;
        }else{
            return ip;
        }
    }
}
