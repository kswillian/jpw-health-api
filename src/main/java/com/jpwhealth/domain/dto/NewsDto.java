package com.jpwhealth.domain.dto;

import com.jpwhealth.domain.News;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class NewsDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime dateRegister;

    public NewsDto(News news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.author = news.getAuthor();
        this.dateRegister = news.getDateRegister();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDateRegister() {
        return dateRegister;
    }

    public static List<NewsDto> convertModelToDto(List<News> newsList) {
        return newsList.stream().map(NewsDto::new).collect(Collectors.toList());
    }

}
