package com.cheerup.cheerup.service;

import com.cheerup.cheerup.model.Ip;
import com.cheerup.cheerup.model.Visitors;
import com.cheerup.cheerup.repository.IpRepository;
import com.cheerup.cheerup.repository.VisitorsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IpService {

    private final IpRepository ipRepository;
    private final VisitorsRepository visitorsRepository;

    @Transactional
    public void createIp() {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String visitorIp = req.getHeader("X-FORWARDED-FOR");
        if (visitorIp == null) {
            visitorIp = req.getRemoteAddr();
        }

        Optional<Ip> foundIp = ipRepository.findByIpAddress(visitorIp);
        if (!foundIp.isPresent()) {
            Ip ip = new Ip(visitorIp);
            ipRepository.save(ip);

            List<Visitors> visitorsList = visitorsRepository.findAll();
            if (visitorsList.isEmpty()) {
                Visitors visitors = new Visitors(1L);
                visitorsRepository.save(visitors);
            } else {
                Long tempTotalVisitors = visitorsList.get(0).getTotalVisitors();
                Visitors visitors = visitorsRepository.findAll().get(0);
                visitors.updateTotalVisitors(tempTotalVisitors + 1);
            }
        } else {
            System.out.println("throw new RuntimeException(\"이미 접속한 유저입니다.\")");
        }
    }
}