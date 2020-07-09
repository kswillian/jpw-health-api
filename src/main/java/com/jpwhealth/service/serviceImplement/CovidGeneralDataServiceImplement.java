package com.jpwhealth.service.serviceImplement;

import com.jpwhealth.domain.CovidGeneralData;
import com.jpwhealth.domain.form.CovidGeneralDataForm;
import com.jpwhealth.domain.form.converter.ConverterFormToModel;
import com.jpwhealth.client.ApiCovidClient;
import com.jpwhealth.repository.CovidGeneralDataRepository;
import com.jpwhealth.service.CovidGeneralDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CovidGeneralDataServiceImplement implements CovidGeneralDataService {

    @Autowired
    private CovidGeneralDataRepository covidGeneralDataRepository;

    @Override
    public Page<CovidGeneralData> getAll(Pageable pageable) {
        Page<CovidGeneralData> covidGeneralDataList = covidGeneralDataRepository.findAll(pageable);
        return covidGeneralDataList;
    }

    @Override
    public ResponseEntity<CovidGeneralData> getByDate(LocalDateTime date) {
        CovidGeneralData covidGeneralData = covidGeneralDataRepository.findByDate(date);
        return ResponseEntity.ok().body(covidGeneralData);
    }

    @Override
    public CovidGeneralData registerByRequest(CovidGeneralDataForm covidGeneralDataForm){
        CovidGeneralData covidGeneralData = ConverterFormToModel.toCovidGeneralData(covidGeneralDataForm);
        covidGeneralDataRepository.save(covidGeneralData);
        return covidGeneralData;
    }

    @Override
    @Async
    public void register() throws InterruptedException {
        CovidGeneralData covidGeneralData = ApiCovidClient.getCovidGeneralData();
        covidGeneralDataRepository.save(covidGeneralData);
    }

    @Override
    public ResponseEntity delete(Long id) {
        covidGeneralDataRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
