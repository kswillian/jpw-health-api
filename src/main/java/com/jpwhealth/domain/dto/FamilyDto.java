package com.jpwhealth.domain.dto;

import com.jpwhealth.domain.Family;

import java.util.List;
import java.util.stream.Collectors;

public class FamilyDto {

    private Long id;
    private String familyName;
    private String familyResponsible;
    private String city;
    private String uf;

    public FamilyDto(Family family) {
        this.id = family.getId();
        this.familyName = family.getFamilyName();
        this.familyResponsible = family.getFamilyResponsible();
        this.city = family.getCity();
        this.uf = family.getUf();
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

    public String getCity() {
        return city;
    }

    public String getUf() {
        return uf;
    }

    public static List<FamilyDto> convertModelToDto(List<Family> families) {
        return families.stream().map(FamilyDto::new).collect(Collectors.toList());
    }

}
