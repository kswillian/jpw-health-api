package com.jpwhealth.domain.form;

import javax.validation.constraints.NotNull;

public class TopicForm {

    @NotNull
    private String name;

    public TopicForm() {
    }

    public String getName() {
        return name;
    }

}
