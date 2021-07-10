package com.cheerup.cheerup.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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