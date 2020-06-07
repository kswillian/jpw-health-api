package com.jpwhealth.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Topic {

    private static final long serialVersionUID = -1905907502453138175L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    private LocalDateTime dateRegister = LocalDateTime.now();

    public Topic() {

    }

    public Topic(Long id, @NotBlank String name, LocalDateTime dateRegister) {
        this.id = id;
        this.name = name;
        this.dateRegister = dateRegister;
    }

    public Topic(@NotBlank String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDateTime dateRegister) {
        this.dateRegister = dateRegister;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateRegister=" + dateRegister +
                '}';
    }
}
