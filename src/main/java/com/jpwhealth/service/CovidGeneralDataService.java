package com.jpwhealth.service;

import com.jpwhealth.domain.CovidGeneralData;
import com.jpwhealth.domain.form.CovidGeneralDataForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public interface CovidGeneralDataService {

    Page<CovidGeneralData> getAll(Pageable pageable);

    ResponseEntity<CovidGeneralData> getByDate(LocalDateTime date);

    void register() throws InterruptedException;

    CovidGeneralData registerByRequest(CovidGeneralDataForm covidGeneralDataForm);

    ResponseEntity delete(Long id);

}
