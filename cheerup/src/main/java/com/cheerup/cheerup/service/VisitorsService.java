package com.cheerup.cheerup.service;

import com.cheerup.cheerup.model.Ip;
import com.cheerup.cheerup.repository.IpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class VisitorsService {
    private final IpRepository ipRepository;

    public Map<String, Object> visitorsCounter() {
        List<Ip> IpList = ipRepository.findAllByOrderByTotalVisitorsDesc();
        Long totalVisitors = IpList.get(0).getTotalVisitors();

        Map<String, Object> visitors = new HashMap<>();
        visitors.put("totalVisitors", totalVisitors);
        visitors.put("todayVisitors", IpList.size());

        return visitors;
    }
}