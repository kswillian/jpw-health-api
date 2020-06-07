package com.jpwhealth.domain.form;

import com.jpwhealth.domain.Topic;

import javax.validation.constraints.NotNull;

public class TopicForm {

    @NotNull
    private String name;

    public TopicForm() {
    }

    public String getName() {
        return name;
    }

    public static Topic convertFormToModel(TopicForm topicForm){
        return new Topic(topicForm.getName());
    }

}
