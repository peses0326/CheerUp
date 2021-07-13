package com.cheerup.cheerup.dto;

import lombok.Getter;

@Getter
public class CommentLikeItRequestDto {
    private String username;
    private Long commentId;
}
