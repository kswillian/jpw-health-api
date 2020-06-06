package com.jpwhealth.controller;

import com.jpwhealth.domain.Family;
import com.jpwhealth.domain.dto.FamilyDto;
import com.jpwhealth.domain.form.FamilyForm;
import com.jpwhealth.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @GetMapping("/family")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.ok(familyService.getAll());
    }

    @GetMapping("/family/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return ResponseEntity.ok(familyService.getById(id));
    }

    @PostMapping("/family")
    public ResponseEntity<FamilyDto> register(@Valid @RequestBody FamilyForm familyForm){
        System.out.println("Controller");
        System.out.println("::::" + familyForm.toString());

        Family family = familyService.register(familyForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(new FamilyDto(family));
    }

}
