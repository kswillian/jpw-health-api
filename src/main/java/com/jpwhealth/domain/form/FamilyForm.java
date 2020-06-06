package com.jpwhealth.domain.form;

import com.jpwhealth.domain.Family;
import com.jpwhealth.domain.Sex;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class FamilyForm {

    @NotNull
    private String familyName;

    @NotNull
    private String familyResponsible;

    @NotNull
    private String responsibleCPF;

    @NotNull
    private String responsibleRG;

    @NotNull
    @DateTimeFormat
    private LocalDateTime dateBirth;

    private Integer adultsNumber;

    private Integer childrenNumber;

    private Integer unemployedNumber;

    @NotNull
    private Long familyFinance;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex responsibleSex;

    @NotNull
    private String uf;

    @NotNull
    private String city;

    private Long latitude;
    private Long longitude;

    public FamilyForm(@NotBlank String familyName, @NotBlank String familyResponsible, @NotBlank String responsibleCPF, @NotBlank String responsibleRG, @NotBlank LocalDateTime dateBirth, Integer adultsNumber, Integer childrenNumber, Integer unemployedNumber, @NotNull Long familyFinance, @NotBlank Sex responsibleSex, @NotBlank String uf, @NotBlank String city, Long latitude, Long longitude) {
        this.familyName = familyName;
        this.familyResponsible = familyResponsible;
        this.responsibleCPF = responsibleCPF;
        this.responsibleRG = responsibleRG;
        this.dateBirth = dateBirth;
        this.adultsNumber = adultsNumber;
        this.childrenNumber = childrenNumber;
        this.unemployedNumber = unemployedNumber;
        this.familyFinance = familyFinance;
        this.responsibleSex = responsibleSex;
        this.uf = uf;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public Long getLatitude() {
        return latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public static Family convertFormToModel(FamilyForm familyForm){
        Family family = new Family();
        family.setFamilyName(familyForm.getFamilyName());
        family.setFamilyResponsible(familyForm.getFamilyResponsible());
        family.setResponsibleCPF(familyForm.getResponsibleCPF());
        family.setResponsibleRG(familyForm.getResponsibleRG());
        family.setDateBirth(familyForm.getDateBirth());
        family.setAdultsNumber(familyForm.getAdultsNumber());
        family.setChildrenNumber(familyForm.getChildrenNumber());
        family.setUnemployedNumber(familyForm.getUnemployedNumber());
        family.setFamilyFinance(familyForm.getFamilyFinance());
        family.setResponsibleSex(familyForm.getResponsibleSex());
        family.setUf(familyForm.getUf());
        family.setCity(familyForm.getCity());
        family.setLatitude(familyForm.getLatitude());
        family.setLongitude(familyForm.longitude);
        return family;
    }

    @Override
    public String toString() {
        return "FamilyForm{" +
                "familyName='" + familyName + '\'' +
                ", familyResponsible='" + familyResponsible + '\'' +
                ", responsibleCPF='" + responsibleCPF + '\'' +
                ", responsibleRG='" + responsibleRG + '\'' +
                ", dateBirth=" + dateBirth +
                ", adultsNumber=" + adultsNumber +
                ", childrenNumber=" + childrenNumber +
                ", unemployedNumber=" + unemployedNumber +
                ", familyFinance=" + familyFinance +
                ", responsibleSex=" + responsibleSex +
                ", uf='" + uf + '\'' +
                ", city='" + city + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

}
