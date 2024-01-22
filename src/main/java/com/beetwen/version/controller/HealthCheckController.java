package com.beetwen.version.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckController {
    @GetMapping("/health-check")
    public Map<String, Object> findPriceByObject() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "OK");
        return response;
    }
}
