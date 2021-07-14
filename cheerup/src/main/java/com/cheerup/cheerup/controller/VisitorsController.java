package com.cheerup.cheerup.controller;

import com.cheerup.cheerup.model.Ip;
import com.cheerup.cheerup.model.Visitors;
import com.cheerup.cheerup.repository.IpRepository;
import com.cheerup.cheerup.repository.VisitorsRepository;
import com.cheerup.cheerup.service.IpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class VisitorsController {

    private final IpService ipService;
    private final IpRepository ipRepository;
    private final VisitorsRepository visitorsRepository;

    @GetMapping("/visitors")
    public Map<String, Long> checkVisitors() {
        ipService.createIp();
        Long todayVisitors = ipRepository.count();
        Long totalVisitors = visitorsRepository.findAll().get(0).getTotalVisitors();
        Map<String, Long> visitors = new HashMap<>();
        visitors.put("todayVisitors", todayVisitors);
        visitors.put("totalVisitors", totalVisitors);
        return visitors;
    }

    @GetMapping("/ip")
    public List<Ip> checkIp() {
        return ipRepository.findAll();
    }
}