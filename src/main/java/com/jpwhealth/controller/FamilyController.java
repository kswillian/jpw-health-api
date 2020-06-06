package com.jpwhealth.controller;

import com.jpwhealth.domain.Family;
import com.jpwhealth.domain.dto.FamilyDto;
import com.jpwhealth.domain.form.FamilyForm;
import com.jpwhealth.domain.form.FamilyFormUpdate;
import com.jpwhealth.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
        Family family = familyService.register(familyForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(new FamilyDto(family));
    }

    @PutMapping("/family")
    public ResponseEntity<FamilyDto> update(@Valid  @RequestBody FamilyFormUpdate familyFormUpdate){
        return familyService.update(familyFormUpdate);
    }

    @DeleteMapping("/family/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return familyService.delete(id);
    }

}
