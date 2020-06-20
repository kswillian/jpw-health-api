package com.jpwhealth.service.serviceImplement;

import com.jpwhealth.configuration.exception.CpfAlreadyRegisteredException;
import com.jpwhealth.configuration.exception.ResourceNotFoundException;
import com.jpwhealth.domain.Family;
import com.jpwhealth.domain.dto.FamilyDetailedDto;
import com.jpwhealth.domain.dto.FamilyDto;
import com.jpwhealth.domain.form.FamilyForm;
import com.jpwhealth.domain.form.FamilyFormUpdate;
import com.jpwhealth.repository.FamilyRepository;
import com.jpwhealth.service.FamilyService;
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
        return FamilyDetailedDto.convertModelToDto(families);
    }

    @Override
    public ResponseEntity<FamilyDetailedDto> getById(Long id) {
        verifyIfFamilyExists(id);
        Optional<Family> family = familyRepository.findById(id);
        return ResponseEntity.ok().body(new FamilyDetailedDto(family.get()));
    }

    @Override
    public Family register(FamilyForm familyForm) {
        verifyIfCpfExists(familyForm.getResponsibleCPF());
        Family family = FamilyForm.convertFormToModel(familyForm);
        familyRepository.save(family);
        return family;
    }

    @Override
    public ResponseEntity<FamilyDto> update(FamilyFormUpdate familyFormUpdate) {
        verifyIfFamilyExists(familyFormUpdate.getId());
        Family familyUpdate = FamilyFormUpdate.convertFormToModel(familyFormUpdate);
        familyRepository.save(familyUpdate);
        return ResponseEntity.ok().body(new FamilyDto(familyUpdate));
    }

    @Override
    public ResponseEntity delete(Long id) {
        verifyIfFamilyExists(id);
        familyRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private void verifyIfFamilyExists(Long id){
        if(!familyRepository.findById(id).isPresent()){
            throw new ResourceNotFoundException("Family", id);
        }
    }

    private void verifyIfCpfExists(String cpf){
        if(familyRepository.existsByResponsibleCPF(cpf)){
            throw new CpfAlreadyRegisteredException(cpf);
        }
    }

}
