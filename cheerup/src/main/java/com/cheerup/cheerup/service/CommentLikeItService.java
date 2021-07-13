package com.cheerup.cheerup.service;

import com.cheerup.cheerup.dto.CommentLikeItRequestDto;
import com.cheerup.cheerup.model.CommentLikeIt;
import com.cheerup.cheerup.repository.CommentLikeItRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentLikeItService {

    private final CommentLikeItRepository commentLikeItRepository;

    @Transactional
    public String commentILikeIt(CommentLikeItRequestDto requestDto) {
        CommentLikeIt commentLikeIt = new CommentLikeIt(requestDto);
        Optional<CommentLikeIt> commentLikeSize = Optional.ofNullable(commentLikeItRepository.findByUsernameAndCommentId(requestDto.getUsername(), requestDto.getCommentId()));
        if (commentLikeSize.isPresent()) { // 이미 좋아요를 누른 상태
            commentLikeItRepository.deleteByUsernameAndCommentId(requestDto.getUsername(), requestDto.getCommentId());
            return requestDto.getCommentId() + " commentLikeIt cancelled!";
        } else { // 좋아요를 누르지 않은 상태
            commentLikeItRepository.save(commentLikeIt);
            return requestDto.getCommentId() + " commentLikeIt!";
        }
    }
}
