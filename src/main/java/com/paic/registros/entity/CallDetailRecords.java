package com.paic.registros.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "call_detail_records")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CallDetailRecords {
    @NotNull
    private Timestamp recordDate;
    private Integer lSpc;
    private Integer lSsn;
    private Integer lRi;
    private Integer lGtI;
    private String lGtDigits;
    private Integer rSpc;
    private Integer rSsn;
    private Integer rRi;
    private Integer rGtI;
    private String rGtDigits;
    private String serviceCode;
    private Integer orNature;
    private Integer orPlan;
    private String orDigits;
    private Integer deNature;
    private Integer dePlan;
    private String deDigits;
    private Integer isdnNature;
    private Integer isdnPlan;
    private String msisdn;
    private Integer vlrNature;
    private Integer vlrPlan;
    private String vlrDigits;
    private String imsi;
    @NotNull
    private String status;
    @NotNull
    private String type;
    @NotNull
    private Timestamp tstamp;
    private BigDecimal localDialogId;
    private BigDecimal remoteDialogId;
    private BigDecimal dialogDuration;
    private String ussdString;
    @Id
    @NotNull
    private String id;
}
