package com.cheerup.cheerup.service;

import com.cheerup.cheerup.repository.IpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Scheduler {

    private final IpRepository ipRepository;

    @Scheduled(cron = "0 0 0 * * *") // 매일 0시 0분 0초에 실행
    public void initializeTodayVisitors() {
        ipRepository.deleteAll();
    }
}