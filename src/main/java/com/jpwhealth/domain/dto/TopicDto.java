package com.jpwhealth.domain.dto;

import com.jpwhealth.domain.Topic;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<TopicDto> convertModelToDto(List<Topic> topics) {
        return topics.stream().map(TopicDto::new).collect(Collectors.toList());
    }

}
