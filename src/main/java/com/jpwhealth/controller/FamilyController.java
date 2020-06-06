package com.jpwhealth.controller;

import com.jpwhealth.domain.Family;
import com.jpwhealth.domain.dto.FamilyDetailedDto;
import com.jpwhealth.domain.dto.FamilyDto;
import com.jpwhealth.domain.form.FamilyForm;
import com.jpwhealth.domain.form.FamilyFormUpdate;
import com.jpwhealth.service.FamilyService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Lista o cadastro de familias", notes = "Lista o cadastro de familias necessitadas de auxilio", response = FamilyDto.class, responseContainer = "List" )
    @GetMapping("/family")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.ok(familyService.getAll());
    }

    @ApiOperation(value = "Lista o cadastro de familias por id", notes = "Lista o cadastro de familias necessitadas de auxilio", response = FamilyDetailedDto.class, responseContainer = "Object" )
    @GetMapping("/family/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return ResponseEntity.ok(familyService.getById(id));
    }

    @ApiOperation(value = "Insere uma nova familia", notes = "Insere o cadastro de uma nova familia na nossa base de dados", response = FamilyDto.class, responseContainer = "Object" )
    @PostMapping("/family")
    public ResponseEntity<FamilyDto> register(@Valid @RequestBody FamilyForm familyForm){
        Family family = familyService.register(familyForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(new FamilyDto(family));
    }

    @ApiOperation(value = "Atualiza o cadastro de uma familia", notes = "Atualizados o dados cadastrais da familia", response = FamilyDto.class, responseContainer = "Object" )
    @PutMapping("/family")
    public ResponseEntity<FamilyDto> update(@Valid  @RequestBody FamilyFormUpdate familyFormUpdate){
        return familyService.update(familyFormUpdate);
    }

    @ApiOperation(value = "Remove o cadastro de familia", notes = "Remove o registro cadastral da familia informada", response = ResponseEntity.class, responseContainer = "Object" )
    @DeleteMapping("/family/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return familyService.delete(id);
    }

}
