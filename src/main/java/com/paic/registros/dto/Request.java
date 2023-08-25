package com.paic.registros.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class Request {
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty("record_date_start")
    LocalDateTime recordDateStart;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty("record_date_end")
    LocalDateTime recordDateEnd;
    String msisdn;
    String imsi;

    // Convertir fecha 2023-08-18 10:30:00 a 2023-08-18T10:30:00
    public void setRecordDateStart(String recordDateStart) {
        this.recordDateStart = LocalDateTime.parse(recordDateStart.replace(" ", "T"));
    }

    // Convertir fecha 2023-08-18 10:30:00 a 2023-08-18T10:30:00
    public void setRecordDateEnd(String recordDateEnd) {
        this.recordDateEnd = LocalDateTime.parse(recordDateEnd.replace(" ", "T"));
    }
}
