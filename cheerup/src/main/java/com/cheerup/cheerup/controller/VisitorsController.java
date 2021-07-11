package com.cheerup.cheerup.controller;


import com.cheerup.cheerup.service.VisitorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@RequiredArgsConstructor
@Controller
public class VisitorsController {

    private final VisitorsService visitorsService;

    @GetMapping("/visitors")
    public Map<String, Object> getArticle() {
        return visitorsService.visitorsCounter();
    }
}
