package com.jpwhealth.jpwClient;

import com.jpwhealth.domain.CovidGeneralData;
import com.jpwhealth.repository.CovidGeneralDataRepository;

public class ThreadCovidData implements Runnable {

    private CovidGeneralDataRepository covidGeneralDataRepository;

    private static Long DAY_IN_MILLISECONS = (long) (24 * 60 * 60 * 1000);

    public ThreadCovidData(CovidGeneralDataRepository covidGeneralDataRepository) {
        this.covidGeneralDataRepository = covidGeneralDataRepository;
    }

    @Override
    public void run() {
        while(true){
            CovidGeneralData covidGeneralData = ApiCovidClient.getCovidGeneralData();
            covidGeneralDataRepository.save(covidGeneralData);
            try {
                Thread.sleep(DAY_IN_MILLISECONS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
