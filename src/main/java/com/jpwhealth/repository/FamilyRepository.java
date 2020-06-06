package com.jpwhealth.repository;

import com.jpwhealth.domain.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, Long> {

    Boolean existsByResponsibleCPF(String responsibleCPF);

}
