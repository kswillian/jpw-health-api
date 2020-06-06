package com.jpwhealth.service;

import com.jpwhealth.domain.Family;
import com.jpwhealth.domain.dto.FamilyDetailedDto;
import com.jpwhealth.domain.dto.FamilyDto;
import com.jpwhealth.domain.form.FamilyForm;
import com.jpwhealth.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    public List<FamilyDto> getAll(){
        List<Family> families = familyRepository.findAll();
        return FamilyDto.convertDtoToModel(families);
    }

    public ResponseEntity<FamilyDetailedDto> getById(Long id){
        Optional<Family> family = familyRepository.findById(id);

        if(family.isPresent()){
            return ResponseEntity.ok().body(new FamilyDetailedDto(family.get()));
        }

        return ResponseEntity.notFound().build();
    }

    public Family register(FamilyForm familyForm){

        if(familyRepository.existsByResponsibleCPF(familyForm.getResponsibleCPF())){
            throw new RuntimeException(
                    String.format("O CPF %s já se encontra cadastrado!", familyForm.getResponsibleCPF())
            );
        }

        Family family = FamilyForm.convertFormToModel(familyForm);
        familyRepository.save(family);

        return family;

    }

}
