package com.cheerup.cheerup.controller;

import com.cheerup.cheerup.dto.CommentPageRequestDto;
import com.cheerup.cheerup.dto.CommentRequestDto;
import com.cheerup.cheerup.model.Comment;
import com.cheerup.cheerup.repository.CommentRepository;
import com.cheerup.cheerup.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository; // CRUD하려면 DB 필요
    private final CommentService commentService; // 업데이트용

    @GetMapping("/comment") // 댓글 전체 조회
    public List<Comment> readComments() {
        return commentService.commentLikesCounter(commentRepository.findAllByOrderByIdDesc());
    }

    @GetMapping("/comment/page") // Get 방식 댓글 전체 조회
    public Page<Comment> readPagedCommentsByGetMapping(@RequestParam("page") int page, @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return commentService.pagedCommentLikesCounter(commentRepository.findAllByOrderByCreatedAtDesc(pageable));
    }

    @PostMapping("/comment/page") // Post 방식 댓글 전체 조회
    public Page<Comment> readPagedCommentsByPostMapping(@RequestBody CommentPageRequestDto requestDto) {
        Pageable pageable = PageRequest.of(requestDto.getPage() - 1, requestDto.getSize());
        return commentService.pagedCommentLikesCounter(commentRepository.findAllByOrderByCreatedAtDesc(pageable));
    }

    @GetMapping("/comment/{articleId}") // 댓글 게시글 ID 별로 조회
    public List<Comment> readComments(@PathVariable Long articleId) {
        List<Comment> commentList = commentRepository.findAllByArticleIdOrderByModifiedAtDesc(articleId).orElseThrow(() -> new IllegalArgumentException("해당 articleId가 존재하지 않습니다."));
        return commentService.commentLikesCounter(commentList);
    }

    @PostMapping("/comment") // 댓글 생성
    public Comment createComment(@RequestBody CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }

    @PutMapping("/comment/{id}")
    public Long updateText(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        commentService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/comment/{id}")
    public Long deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }
}
