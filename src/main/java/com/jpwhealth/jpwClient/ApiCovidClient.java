package com.jpwhealth.jpwClient;

import com.jpwhealth.domain.CovidGeneralData;
import com.jpwhealth.service.CovidGeneralDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

public class ApiCovidClient {

    private static String URL_COVID_DATA = "https://brasil.io/api/dataset/covid19/caso";
    private static String URL_COVID_DATA_REGION = "https://api.covid19.finspect.me/brcovid19/region";

    private static String TEST = "https://api.covid19api.com/country";

    private CovidGeneralDataService covidGeneralDataService;


    public ApiCovidClient(CovidGeneralDataService covidGeneralDataService) {
        this.covidGeneralDataService = covidGeneralDataService;
    }

    public static void getCovidGeneralDataTest(){

        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri(TEST)
                .build();

        //System.out.println(restTemplate.getForObject("/Brazil?from="+ LocalDateTime.now() +"&to=" + LocalDateTime.now(), Object.class, ""));
        System.out.println(restTemplate.getForObject("/Brazil?from=2020-07-03T00:00:00Z&to=2020-07-03T23:00:00Z", Object.class, ""));

    }

    public static void getCovidGeneralData(){

        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri(URL_COVID_DATA)
                .build();

        CovidGeneralData covidGeneralData = (CovidGeneralData) restTemplate.getForObject("/data?is_last=True&place_type=state&state=RS", Object.class, "");
        //covidGeneralDataService.register(covidGeneralData);

    }

    public static void getCovidForState(){

        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri(URL_COVID_DATA)
                .build();

        System.out.println(restTemplate.getForObject("/data?is_last=True&place_type=state", Object.class, ""));

    }

}
