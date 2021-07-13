package com.cheerup.cheerup.controller;

import com.cheerup.cheerup.service.IpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IpController {

    private final IpService IpService;

    @GetMapping("/ip")
    public void creatIps() {
        IpService.createIp();
    }
}