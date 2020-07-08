package com.jpwhealth.service;

import com.jpwhealth.domain.CovidGeneralData;
import com.jpwhealth.domain.form.CovidGeneralDataForm;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface CovidGeneralDataService {

    List<CovidGeneralData> getAll();

    ResponseEntity<CovidGeneralData> getByDate(LocalDateTime date);

    void register();

    CovidGeneralData registerByRequest(CovidGeneralDataForm covidGeneralDataForm);

    ResponseEntity delete(Long id);

}
