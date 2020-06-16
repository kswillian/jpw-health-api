package com.jpwhealth.domain.dto;

import com.jpwhealth.domain.Address;
import com.jpwhealth.domain.Family;

import java.util.List;
import java.util.stream.Collectors;

public class FamilyDto {

    private Long id;
    private String familyName;
    private String familyResponsible;
    private Address address;

    public FamilyDto(Family family) {
        this.id = family.getId();
        this.familyName = family.getFamilyName();
        this.familyResponsible = family.getFamilyResponsible();
        this.address = family.getAddress();
    }

    public Long getId() {
        return id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getFamilyResponsible() {
        return familyResponsible;
    }

    public Address getAddress() {
        return address;
    }

    public static List<FamilyDto> convertModelToDto(List<Family> families) {
        return families.stream().map(FamilyDto::new).collect(Collectors.toList());
    }

}
