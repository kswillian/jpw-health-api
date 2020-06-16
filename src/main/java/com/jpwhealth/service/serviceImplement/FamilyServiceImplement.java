package com.jpwhealth.service.serviceImplement;

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

        Optional<Family> family = Optional.ofNullable(familyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Familia não encontrada.")));

        if(family.isPresent()){
            return ResponseEntity.ok().body(new FamilyDetailedDto(family.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @Override
    public Family register(FamilyForm familyForm) {

        if(familyRepository.existsByResponsibleCPF(familyForm.getResponsibleCPF())){
            throw new RuntimeException(
                    String.format("O CPF %s já se encontra cadastrado!", familyForm.getResponsibleCPF())
            );
        }

        Family family = FamilyForm.convertFormToModel(familyForm);
        familyRepository.save(family);

        return family;

    }

    @Override
    public ResponseEntity<FamilyDto> update(FamilyFormUpdate familyFormUpdate) {

        Optional<Family> family = Optional.ofNullable(familyRepository.findById(familyFormUpdate.getId())
                .orElseThrow(() -> new RuntimeException("Familia não encontrada.")));

        if(family.isPresent()){
            Family familyUpdate = FamilyFormUpdate.convertFormToModel(familyFormUpdate);
            familyRepository.save(familyUpdate);
            return ResponseEntity.ok().body(new FamilyDto(familyUpdate));
        }

        return ResponseEntity.notFound().build();

    }

    @Override
    public ResponseEntity delete(Long id) {

        Optional<Family> family = Optional.ofNullable(familyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Familia não encontrada.")));

        if(family.isPresent()){
            familyRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }

}
