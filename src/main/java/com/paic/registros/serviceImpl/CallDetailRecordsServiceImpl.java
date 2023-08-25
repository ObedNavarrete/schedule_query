package com.paic.registros.serviceImpl;

import com.paic.registros.dto.Request;
import com.paic.registros.repository.CallDetailRecordsRepository;
import com.paic.registros.service.CallDetailRecordsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service @RequiredArgsConstructor @Slf4j
public class CallDetailRecordsServiceImpl implements CallDetailRecordsService {
    private final CallDetailRecordsRepository repository;

    @Override
    public Map<String, Object> query(Request request) {
        Map<String, Object> response = new HashMap<>();

        try {
            var result = repository.findByRecordDateBetweenAndMsisdnAndImsi
                    (request.getRecordDateStart(),
                            request.getRecordDateEnd(),
                            request.getMsisdn(),
                            request.getImsi());

            if (result.isEmpty()) {
                log.info("No records found");
                response.put("message", "No records found");
                return response;
            }

            response.put("message", result.size() + " records found");
            response.put("data", result);
            return response;
        }catch (Exception e) {
            log.error("Error: " + e.getMessage());
            response.put("message", "Error: " + e.getMessage());
            return response;
        }
    }

}
