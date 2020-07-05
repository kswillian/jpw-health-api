package com.jpwhealth.domain.dto;

import com.jpwhealth.domain.Topic;

public class TopicDto {

    private Long id;
    private String name;

    public TopicDto(Topic topic) {
        this.id = topic.getId();
        this.name = topic.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
