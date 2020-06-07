package com.jpwhealth.domain.form;

import com.jpwhealth.domain.Family;
import com.jpwhealth.domain.Sex;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FamilyFormUpdate {

    @NotNull
    private Long id;

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

    private BigDecimal latitude;
    private BigDecimal longitude;

    public FamilyFormUpdate(@NotNull Long id, @NotNull String familyName, @NotNull String familyResponsible, @NotNull String responsibleCPF, @NotNull String responsibleRG, @NotNull LocalDateTime dateBirth, Integer adultsNumber, Integer childrenNumber, Integer unemployedNumber, @NotNull Long familyFinance, @NotNull Sex responsibleSex, @NotNull String uf, @NotNull String city, BigDecimal latitude, BigDecimal longitude) {
        this.id = id;
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

    public static Family convertFormToModel(FamilyFormUpdate familyFormUpdate){
        Family family = new Family();
        family.setId(familyFormUpdate.getId());
        family.setFamilyName(familyFormUpdate.getFamilyName());
        family.setFamilyResponsible(familyFormUpdate.getFamilyResponsible());
        family.setResponsibleCPF(familyFormUpdate.getResponsibleCPF());
        family.setResponsibleRG(familyFormUpdate.getResponsibleRG());
        family.setDateBirth(familyFormUpdate.getDateBirth());
        family.setAdultsNumber(familyFormUpdate.getAdultsNumber());
        family.setChildrenNumber(familyFormUpdate.getChildrenNumber());
        family.setUnemployedNumber(familyFormUpdate.getUnemployedNumber());
        family.setFamilyFinance(familyFormUpdate.getFamilyFinance());
        family.setResponsibleSex(familyFormUpdate.getResponsibleSex());
        family.setUf(familyFormUpdate.getUf());
        family.setCity(familyFormUpdate.getCity());
        family.setLatitude(familyFormUpdate.getLatitude());
        family.setLongitude(familyFormUpdate.longitude);
        return family;
    }

    @Override
    public String toString() {
        return "FamilyFormUpdate{" +
                "id=" + id +
                ", familyName='" + familyName + '\'' +
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
