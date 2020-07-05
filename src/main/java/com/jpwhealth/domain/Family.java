package com.jpwhealth.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Family {

    private static final long serialVersionUID = -1905907502453138175L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Lob
    private String observation;
    private Sex responsibleSex = Sex.UNDEFINED;

    @Embedded
    private Address address;

    private LocalDateTime dateRegister = LocalDateTime.now();

    public Family() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyResponsible() {
        return familyResponsible;
    }

    public void setFamilyResponsible(String familyResponsible) {
        this.familyResponsible = familyResponsible;
    }

    public String getResponsibleCPF() {
        return responsibleCPF;
    }

    public void setResponsibleCPF(String responsibleCPF) {
        this.responsibleCPF = responsibleCPF;
    }

    public String getResponsibleRG() {
        return responsibleRG;
    }

    public void setResponsibleRG(String responsibleRG) {
        this.responsibleRG = responsibleRG;
    }

    public LocalDateTime getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDateTime dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Integer getAdultsNumber() {
        return adultsNumber;
    }

    public void setAdultsNumber(Integer adultsNumber) {
        this.adultsNumber = adultsNumber;
    }

    public Integer getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(Integer childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    public Integer getUnemployedNumber() {
        return unemployedNumber;
    }

    public void setUnemployedNumber(Integer unemployedNumber) {
        this.unemployedNumber = unemployedNumber;
    }

    public Long getFamilyFinance() {
        return familyFinance;
    }

    public void setFamilyFinance(Long familyFinance) {
        this.familyFinance = familyFinance;
    }

    public Sex getResponsibleSex() {
        return responsibleSex;
    }

    public void setResponsibleSex(Sex responsibleSex) {
        this.responsibleSex = responsibleSex;
    }

    public Address getAddress() {
        return address;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDateTime dateRegister) {
        this.dateRegister = dateRegister;
    }

}