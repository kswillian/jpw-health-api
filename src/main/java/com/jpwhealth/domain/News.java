package com.jpwhealth.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class News {

    private static final long serialVersionUID = -1905907502453138175L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String subTitle;

    @NotBlank
    private String author;

    @NotBlank
    @Lob
    private String message;

    @NotBlank
    private String imageUrl;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Topic> topics;

    private LocalDateTime dateRegister = LocalDateTime.now();

    public News() {
    }

    public News(News news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.subTitle = news.getSubTitle();
        this.author = news.getAuthor();
        this.message = news.getMessage();
        this.imageUrl = news.getImageUrl();
        this.topics = news.getTopics();
        this.dateRegister = news.getDateRegister();
    }

    public News(Long id, @NotBlank String title, @NotBlank String subTitle, @NotBlank String author, @NotBlank String message, @NotBlank String imageUrl, List<Topic> topics, LocalDateTime dateRegister) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.author = author;
        this.message = message;
        this.imageUrl = imageUrl;
        this.topics = topics;
        this.dateRegister = dateRegister;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDateTime dateRegister) {
        this.dateRegister = dateRegister;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", author='" + author + '\'' +
                ", message='" + message + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", topics=" + topics +
                ", dateRegister=" + dateRegister +
                '}';
    }

}
