package com.paic.registros.service;

import com.paic.registros.dto.Request;

import java.util.Map;

public interface CallDetailRecordsService {

    Map<String, Object> query(Request request);
}
