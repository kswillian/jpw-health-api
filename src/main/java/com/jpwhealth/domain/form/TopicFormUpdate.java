package com.jpwhealth.domain.form;

import com.jpwhealth.domain.Topic;

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

    public static Topic convertFormToModel(TopicFormUpdate topicFormUpdate){
        Topic topic = new Topic();
        topic.setId(topicFormUpdate.getId());
        topic.setName(topicFormUpdate.getName());
        return topic;
    }

    @Override
    public String toString() {
        return "TopicFormUpdate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}