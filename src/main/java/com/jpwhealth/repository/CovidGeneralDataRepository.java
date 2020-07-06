package com.jpwhealth.repository;

import com.jpwhealth.domain.CovidGeneralData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface CovidGeneralDataRepository extends JpaRepository<CovidGeneralData, Long> {

    CovidGeneralData findByDate(LocalDateTime date);

}
