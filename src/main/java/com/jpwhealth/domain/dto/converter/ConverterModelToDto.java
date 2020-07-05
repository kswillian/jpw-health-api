package com.jpwhealth.domain.dto.converter;

import com.jpwhealth.domain.Family;
import com.jpwhealth.domain.News;
import com.jpwhealth.domain.Topic;
import com.jpwhealth.domain.dto.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ConverterModelToDto {

    public static List<TopicDetailedDto> toTopicDetailedDto(List<Topic> topics) {
        return topics.stream().map(TopicDetailedDto::new).collect(Collectors.toList());
    }

    public static TopicDto toTopicDto(Topic topic){
        TopicDto topicDto = new TopicDto(topic);
        return topicDto;
    }

    public static Page<News> toNewsDetailedDto(Page<News> newsList){
        return newsList.map(News::new);
    }

    public static NewsDto toNewsDto(News news){
        return new NewsDto(news);
    }

    public static List<FamilyDetailedDto> toFamilyDetailedDto(List<Family> families){
        return families.stream().map(FamilyDetailedDto::new).collect(Collectors.toList());
    }

    public static FamilyDto toFamilyDto(Family family){
        FamilyDto familyDto = new FamilyDto(family);
        return familyDto;
    }
}
