package com.paic.registros.repository;

import com.paic.registros.entity.CallDetailRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public interface CallDetailRecordsRepository extends JpaRepository<CallDetailRecords, Integer> {
    @Query(
            value = "select *\n" +
            "from call_detail_records\n" +
            "where record_date between ?1 and ?2\n" +
            "and\n" +
            "    case\n" +
            "        when ?3 IS NOT NULL then msisdn = ?3\n" +
            "        else 1=1\n" +
            "    end\n" +
            "and\n" +
            "    case\n" +
            "        when ?4 IS NOT NULL then imsi = ?4\n" +
            "        else 1=1\n" +
            "    end;"
            , nativeQuery = true)
    List<Map<String,Object>> findByRecordDateBetweenAndMsisdnAndImsi(LocalDateTime recordDate1, LocalDateTime recordDate2, String msisdn, String imsi);
}
