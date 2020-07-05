package com.jpwhealth.domain.form;

import javax.validation.constraints.NotNull;

public class TopicFormUpdate {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    public TopicFormUpdate(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TopicFormUpdate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
