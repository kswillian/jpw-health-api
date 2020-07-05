package com.jpwhealth.service.serviceImplement;

import com.jpwhealth.configuration.exception.CpfAlreadyRegisteredException;
import com.jpwhealth.domain.Entity;
import com.jpwhealth.domain.Family;
import com.jpwhealth.domain.dto.FamilyDetailedDto;
import com.jpwhealth.domain.dto.FamilyDto;
import com.jpwhealth.domain.dto.converter.ConverterModelToDto;
import com.jpwhealth.domain.form.FamilyForm;
import com.jpwhealth.domain.form.FamilyFormUpdate;
import com.jpwhealth.domain.form.converter.ConverterFormToModel;
import com.jpwhealth.repository.FamilyRepository;
import com.jpwhealth.service.FamilyService;
import com.jpwhealth.validation.RecordValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyServiceImplement implements FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    @Override
    public List<FamilyDetailedDto> getAll() {
        List<Family> families = familyRepository.findAll();
        return ConverterModelToDto.toFamilyDetailedDto(families);
    }

    @Override
    public ResponseEntity<FamilyDetailedDto> getById(Long id) {
        new RecordValidation(familyRepository).verifyIfRecordExist(Entity.Family, id);
        Optional<Family> family = familyRepository.findById(id);
        return ResponseEntity.ok().body(new FamilyDetailedDto(family.get()));
    }

    @Override
    public Family register(FamilyForm familyForm) {
        verifyIfCpfExists(familyForm.getResponsibleCPF());
        Family family = ConverterFormToModel.toFamily(familyForm);
        familyRepository.save(family);
        return family;
    }

    @Override
    public ResponseEntity<FamilyDto> update(FamilyFormUpdate familyFormUpdate) {
        new RecordValidation(familyRepository).verifyIfRecordExist(Entity.Family, familyFormUpdate.getId());
        Family familyUpdate = ConverterFormToModel.toFamily(familyFormUpdate);
        familyRepository.save(familyUpdate);
        return ResponseEntity.ok().body(new FamilyDto(familyUpdate));
    }

    @Override
    public ResponseEntity delete(Long id) {
        new RecordValidation(familyRepository).verifyIfRecordExist(Entity.Family, id);
        familyRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private void verifyIfCpfExists(String cpf){
        if(familyRepository.existsByResponsibleCPF(cpf)){
            throw new CpfAlreadyRegisteredException(cpf);
        }
    }

}
