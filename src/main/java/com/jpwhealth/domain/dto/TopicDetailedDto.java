package com.jpwhealth.domain.dto;

import com.jpwhealth.domain.Topic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicDetailedDto {

    private Long id;
    private String name;
    private LocalDateTime dateRegister;

    public TopicDetailedDto(Topic topic) {
        this.id = topic.getId();
        this.name = topic.getName();
        this.dateRegister = topic.getDateRegister();
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

    public static List<TopicDto> convertModelToDto(List<Topic> topics) {
        return topics.stream().map(TopicDto::new).collect(Collectors.toList());
    }

}
