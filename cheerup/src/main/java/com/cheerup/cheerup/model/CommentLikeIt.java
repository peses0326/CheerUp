package com.cheerup.cheerup.model;

import com.cheerup.cheerup.dto.CommentLikeItRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class CommentLikeIt {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private Long commentId;

    public CommentLikeIt(CommentLikeItRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.commentId = requestDto.getCommentId();
    }
}