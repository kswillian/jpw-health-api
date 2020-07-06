package com.jpwhealth.service.serviceImplement;

import com.jpwhealth.domain.CovidGeneralData;
import com.jpwhealth.jpwClient.ApiCovidClient;
import com.jpwhealth.repository.CovidGeneralDataRepository;
import com.jpwhealth.service.CovidGeneralDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CovidGeneralDataServiceImplement implements CovidGeneralDataService {

    @Autowired
    private CovidGeneralDataRepository covidGeneralDataRepository;

    private static Long DAY_IN_MILLISECONS = (long) (24 * 60 * 60 * 1000);

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
    @Async
    public void register() throws InterruptedException {
        while(true){
            CovidGeneralData covidGeneralData = ApiCovidClient.getCovidGeneralDataTest();
            covidGeneralDataRepository.save(covidGeneralData);
            System.out.println(covidGeneralData.toString());
            Thread.sleep(DAY_IN_MILLISECONS);
        }

    }

    @Override
    public ResponseEntity delete(Long id) {
        covidGeneralDataRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
