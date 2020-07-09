package com.jpwhealth.component;

import com.jpwhealth.service.CovidGeneralDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClientRunner implements CommandLineRunner {

    private static Long DAY_IN_MILLISECONS = (long) (24 * 60 * 60 * 1000);
    private static Long HOUR_IN_MILLISECONS = DAY_IN_MILLISECONS / 12;

    @Autowired
    private CovidGeneralDataService covidGeneralDataService;

    @Override
    public void run(String... args) throws Exception {
        while(true){
            covidGeneralDataService.register();
            Thread.sleep(HOUR_IN_MILLISECONS);
        }
    }


}
