package com.jpwhealth.domain.dto;

import com.jpwhealth.domain.Family;
import com.jpwhealth.domain.Sex;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyDetailedDto {

    private Long id;
    private String familyName;
    private String familyResponsible;
    private String responsibleCPF;
    private String responsibleRG;
    private LocalDateTime dateBirth;
    private Integer adultsNumber;
    private Integer childrenNumber;
    private Integer unemployedNumber;
    private Long familyFinance;
    private Sex responsibleSex;
    private String uf;
    private String city;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDateTime dateRegister;

    public FamilyDetailedDto(Family family) {
        this.id = family.getId();
        this.familyName = family.getFamilyName();
        this.familyResponsible = family.getFamilyResponsible();
        this.responsibleCPF = family.getResponsibleCPF();
        this.responsibleRG = family.getResponsibleRG();
        this.dateBirth = family.getDateBirth();
        this.adultsNumber = family.getAdultsNumber();
        this.childrenNumber = family.getChildrenNumber();
        this.unemployedNumber = family.getUnemployedNumber();
        this.familyFinance = family.getFamilyFinance();
        this.responsibleSex = family.getResponsibleSex();
        this.uf = family.getUf();
        this.city = family.getCity();
        this.latitude = family.getLatitude();
        this.longitude = family.getLongitude();
        this.dateRegister = family.getDateRegister();
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

    public String getResponsibleCPF() {
        return responsibleCPF;
    }

    public String getResponsibleRG() {
        return responsibleRG;
    }

    public LocalDateTime getDateBirth() {
        return dateBirth;
    }

    public Integer getAdultsNumber() {
        return adultsNumber;
    }

    public Integer getChildrenNumber() {
        return childrenNumber;
    }

    public Integer getUnemployedNumber() {
        return unemployedNumber;
    }

    public Long getFamilyFinance() {
        return familyFinance;
    }

    public Sex getResponsibleSex() {
        return responsibleSex;
    }

    public String getUf() {
        return uf;
    }

    public String getCity() {
        return city;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public LocalDateTime getDateRegister() {
        return dateRegister;
    }

    public static List<FamilyDto> convertModelToDto(List<Family> families) {
        return families.stream().map(FamilyDto::new).collect(Collectors.toList());
    }
}
