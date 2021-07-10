package com.cheerup.cheerup.controller;

import com.cheerup.cheerup.model.Saying;
import com.cheerup.cheerup.repository.SayingRepository;
import com.cheerup.cheerup.service.SayingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequiredArgsConstructor
@RestController
public class SayingController {

    private final SayingService SayingService;

    private final SayingRepository SayingRepository;

    @GetMapping("/api/Saying")
    public Saying getSaying() {
        Random rand = new Random();
        long num = rand.nextInt(100);
        return SayingService.getSaying(num);
    }
}
