package com.jpwhealth.repository;

import com.jpwhealth.domain.CovidGeneralData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;

public interface CovidGeneralDataRepository extends PagingAndSortingRepository<CovidGeneralData, Long> {

    CovidGeneralData findByDate(LocalDateTime date);

}
