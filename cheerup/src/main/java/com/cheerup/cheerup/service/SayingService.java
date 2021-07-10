package com.cheerup.cheerup.service;

import com.cheerup.cheerup.model.Saying;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SayingService {


    private final com.cheerup.cheerup.repository.SayingRepository SayingRepository;

    public Saying getSaying(Long num) {
        return SayingRepository.findByNum(num);
    }
}