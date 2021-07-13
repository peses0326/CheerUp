package com.cheerup.cheerup.controller;

import com.cheerup.cheerup.dto.CommentLikeItRequestDto;
import com.cheerup.cheerup.model.CommentLikeIt;
import com.cheerup.cheerup.repository.CommentLikeItRepository;
import com.cheerup.cheerup.service.CommentLikeItService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentLikeItController {

    private final CommentLikeItRepository commentLikeItRepository; // CRUD하려면 DB 필요
    private final CommentLikeItService commentLikeItService; // 업데이트용

    @GetMapping("/commentLikeIt") // 좋아요 전체 조회
    public List<CommentLikeIt> readCommentLikes() {
        return commentLikeItRepository.findAll();
    }

    @GetMapping("/commentLikeIt/{commentId}") // 댓글 ID 별로 조회
    public List<CommentLikeIt> readCommentLikesById(@PathVariable Long commentId) {
        return commentLikeItRepository.findAllByCommentId(commentId).orElseThrow(() -> new IllegalArgumentException("해당 commentId가 존재하지 않습니다."));
    }

    @GetMapping("/commentLikeItCounter") // 좋아요 총갯수 조회
    public Long readCommentLikesCounter() {
        return (long) (commentLikeItRepository.findAll()).size();
    }

    @PostMapping("/commentLikeIt") // 좋아요!
    public String clickLike(@RequestBody CommentLikeItRequestDto requestDto) {
        return commentLikeItService.commentILikeIt(requestDto);
    }
}
