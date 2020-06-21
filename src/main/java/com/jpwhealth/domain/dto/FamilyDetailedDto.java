package com.jpwhealth.domain.dto;

import com.jpwhealth.domain.Address;
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
    private String observation;
    private Address address;
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
        this.observation = family.getObservation();
        this.address = family.getAddress();
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

    public String getObservation() {
        return observation;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDateTime getDateRegister() {
        return dateRegister;
    }

    public static List<FamilyDetailedDto> convertModelToDto(List<Family> families) {
        return families.stream().map(FamilyDetailedDto::new).collect(Collectors.toList());
    }

}
