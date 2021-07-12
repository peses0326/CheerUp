package com.cheerup.cheerup.model;

import com.cheerup.cheerup.dto.ArticleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity
public class Article extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String saying;

    @Transient
    private Long commentsCount;

    public void addCommentsCount(Long count) {
        this.commentsCount = count;}

    public Article(String saying, String username, String content) {
        this.saying = saying;
        this.username = username;
        this.content = content;
    }

    public Article(ArticleRequestDto requestDto) {
        this.saying = requestDto.getSaying();
        this.username = requestDto.getUsername();
        this.content = requestDto.getContent();
    }

    public Article(ArticleRequestDto requestDto, String username) {
        this.saying = requestDto.getSaying();
        this.username = username;
        this.content = requestDto.getContent();
    }

}