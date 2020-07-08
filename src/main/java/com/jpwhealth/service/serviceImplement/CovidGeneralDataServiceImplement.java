package com.jpwhealth.service.serviceImplement;

import com.jpwhealth.domain.CovidGeneralData;
import com.jpwhealth.domain.form.CovidGeneralDataForm;
import com.jpwhealth.domain.form.converter.ConverterFormToModel;
import com.jpwhealth.jpwClient.ThreadCovidData;
import com.jpwhealth.repository.CovidGeneralDataRepository;
import com.jpwhealth.service.CovidGeneralDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CovidGeneralDataServiceImplement implements CovidGeneralDataService {

    @Autowired
    private CovidGeneralDataRepository covidGeneralDataRepository;

    @Override
    public List<CovidGeneralData> getAll() {
        List<CovidGeneralData> covidGeneralDataList = covidGeneralDataRepository.findAll();
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
    public void register() {
        new ThreadCovidData(covidGeneralDataRepository).run();
    }

    @Override
    public ResponseEntity delete(Long id) {
        covidGeneralDataRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
