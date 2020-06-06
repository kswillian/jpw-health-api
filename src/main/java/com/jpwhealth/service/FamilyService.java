package com.jpwhealth.service;

import com.jpwhealth.domain.Family;
import com.jpwhealth.domain.dto.FamilyDetailedDto;
import com.jpwhealth.domain.dto.FamilyDto;
import com.jpwhealth.domain.form.FamilyForm;
import com.jpwhealth.domain.form.FamilyFormUpdate;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FamilyService {

    List<FamilyDto> getAll();

    ResponseEntity<FamilyDetailedDto> getById(Long id);

    Family register(FamilyForm familyForm);

    ResponseEntity<FamilyDto> update(FamilyFormUpdate familyFormUpdate);

    ResponseEntity delete(Long id);

}
