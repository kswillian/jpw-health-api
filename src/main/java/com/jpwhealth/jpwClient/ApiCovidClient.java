package com.jpwhealth.jpwClient;

import com.jpwhealth.domain.CovidGeneralData;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ApiCovidClient {

    private static String URL_COVID_DATA = "https://api.covid19api.com/country";
    
    public static CovidGeneralData getCovidGeneralDataTest(){
        
        LocalDateTime dateInit = LocalDate.now().atTime(00, 00);
        LocalDateTime dateFinal = LocalDate.now().atTime(00, 01);

        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri(URL_COVID_DATA)
                .build();

        CovidGeneralData[] covidGeneralData = restTemplate.getForObject("/Brazil?from="+ dateInit +"&to="+ dateFinal, CovidGeneralData[].class, "");
        return covidGeneralData[0];

    }

}
