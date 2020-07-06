package com.jpwhealth.controller;

import com.jpwhealth.domain.CovidGeneralData;
import com.jpwhealth.service.CovidGeneralDataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class CovidGeneralDataController {

    @Autowired
    private CovidGeneralDataService covidGeneralDataService;

    @ApiOperation(value = "Lista o registro de dados da COVID-19 no Brasil, a atualização dos dados é realizada diariamente em nossa base de dados", notes = "Lista os números da COVID-19", response = CovidGeneralData.class, responseContainer = "List")
    @GetMapping("/covid-19/BR")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.ok(covidGeneralDataService.getAll());
    }

    @PostMapping("/covid-19/init")
    public ResponseEntity initAsyncTask() throws InterruptedException {
        covidGeneralDataService.register();
        return ResponseEntity.ok().body("Thread initialized!");
    }

    @ApiOperation(value = "Deleta o registro de dados da COVID-19 no Brasil por id", notes = "Removel o dado da COVID-19 informado.", response = CovidGeneralData.class, responseContainer = "List" )
    @DeleteMapping("/covid-19/BR/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return covidGeneralDataService.delete(id);
    }

}
