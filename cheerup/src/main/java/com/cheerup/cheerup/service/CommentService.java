package com.cheerup.cheerup.service;

import com.cheerup.cheerup.dto.CommentRequestDto;
import com.cheerup.cheerup.model.Comment;
import com.cheerup.cheerup.repository.CommentLikeItRepository;
import com.cheerup.cheerup.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentLikeItRepository commentLikeItRepository;

    @Transactional
    public Long update(Long id, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        comment.update(requestDto);
        return comment.getId();
    }


    public List<Comment> commentLikesCounter(List<Comment> commentList) {
        for (Comment value : commentList) {
            Long commentId = value.getId();
            Long likesCount = commentLikeItRepository.countByCommentId(commentId);
            value.addCommentLikesCount(likesCount);
        }
        return commentList;
    }
}
