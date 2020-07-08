package com.jpwhealth.jpwClient;

import com.jpwhealth.domain.CovidGeneralData;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ApiCovidClient {

    private static String URL_COVID_DATA = "https://api.covid19api.com/country";
    
    public static CovidGeneralData getCovidGeneralData(){
        
        LocalDateTime dateInit = LocalDate.now().atTime(00, 00).minusDays(1);
        LocalDateTime dateFinal = LocalDate.now().atTime(00, 01).minusDays(1);

        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri(URL_COVID_DATA)
                .build();

        CovidGeneralData[] covidGeneralData = restTemplate.getForObject("/Brazil?from="+ dateInit +":00&to="+ dateFinal +":00", CovidGeneralData[].class, "");
        return covidGeneralData[0];

    }

}
