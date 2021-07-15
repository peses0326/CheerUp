package com.cheerup.cheerup.service;

import com.cheerup.cheerup.dto.LikeItRequestDto;
import com.cheerup.cheerup.model.LikeIt;
import com.cheerup.cheerup.repository.LikeItRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikeItService {

    private final LikeItRepository likeItRepository;

    @Transactional
    public Map<String, Object> iLikeIt(LikeItRequestDto requestDto) {
        LikeIt likeIt = new LikeIt(requestDto);
        Map<String, Object> likeItMap = new HashMap<>();
        Optional<LikeIt> likeSize = Optional.ofNullable(likeItRepository.findByUsernameAndArticleId(requestDto.getUsername(), requestDto.getArticleId()));
        if (likeSize.isPresent()) { // 이미 좋아요를 누른 상태
            likeItRepository.deleteByUsernameAndArticleId(requestDto.getUsername(), requestDto.getArticleId());
            likeItMap.put("articleId", requestDto.getArticleId());
            likeItMap.put("likeIt", false);
        } else { // 좋아요를 누르지 않은 상태
            likeItRepository.save(likeIt);
            likeItMap.put("articleId", requestDto.getArticleId());
            likeItMap.put("likeIt", true);
        }
        return likeItMap;
    }
}
