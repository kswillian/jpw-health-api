package com.jpwhealth.domain.form;

import com.jpwhealth.domain.Address;
import com.jpwhealth.domain.Family;
import com.jpwhealth.domain.Sex;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;;
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
    private Address address;

    public FamilyForm(@NotNull String familyName, @NotNull String familyResponsible, @NotNull String responsibleCPF, @NotNull String responsibleRG, @NotNull LocalDateTime dateBirth, Integer adultsNumber, Integer childrenNumber, Integer unemployedNumber, @NotNull Long familyFinance, @NotNull Sex responsibleSex, @NotNull Address address) {
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
        this.address = address;
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

    public Address getAddress() {
        return address;
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
        family.setAddress(familyForm.getAddress());
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
                ", address=" + address +
                '}';
    }
}
