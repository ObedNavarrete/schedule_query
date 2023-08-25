package com.paic.registros.controller;

import com.paic.registros.dto.Request;
import com.paic.registros.service.CallDetailRecordsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CallDetailRecrdController {
    private final CallDetailRecordsService service;

    @PostMapping("/cdr/query")
    public ResponseEntity<Map<String, Object>> query(@RequestBody Request request) {
        log.info("Request: {}", request.toString());
        return ResponseEntity.ok(service.query(request));
    }
}
