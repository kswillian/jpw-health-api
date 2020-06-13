package com.jpwhealth.service.serviceImplement;

import com.jpwhealth.domain.News;
import com.jpwhealth.domain.Topic;
import com.jpwhealth.domain.dto.NewsDetailedDto;
import com.jpwhealth.domain.dto.NewsDto;
import com.jpwhealth.domain.form.NewsForm;
import com.jpwhealth.domain.form.NewsFormUpdate;
import com.jpwhealth.repository.NewsRepository;
import com.jpwhealth.repository.TopicRepository;
import com.jpwhealth.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NewsServiceImplement implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<NewsDto> getAll() {
        List<News> newsList = newsRepository.findAll();
        return NewsDto.convertModelToDto(newsList);
    }

    @Override
    public ResponseEntity<?> getById(Long id) {

        Optional<News> news = Optional.ofNullable(newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("A news %s não foi encontrada", id))));

        List<Topic> topics = news.get().getTopics();

        if(news.isPresent()){
            return ResponseEntity.ok().body(new NewsDetailedDto(news.get(), topics));
        }

        return ResponseEntity.notFound().build();

    }

    @Override
    public News register(NewsForm newsForm) {
        List<Topic> topics = topicRepository.findAllById(newsForm.getTopicId());
        News news = NewsForm.convertFormToModel(newsForm, topics);
        newsRepository.save(news);
        return news;
    }

    @Override
    public ResponseEntity<NewsDto> update(NewsFormUpdate newsFormUpdate) {

        Optional<News> news = Optional.ofNullable(newsRepository.findById(newsFormUpdate.getId())
                .orElseThrow(() -> new RuntimeException(String.format("A news %s não foi encontrada", newsFormUpdate.getId()))));

        List<Topic> topics = topicRepository.findAllById(newsFormUpdate.getTopicId());

        if(news.isPresent()){
            News newsUpdate = NewsFormUpdate.convertFormToModel(newsFormUpdate, topics);
            newsRepository.save(newsUpdate);
            return ResponseEntity.ok().body(new NewsDto(newsUpdate));
        }

        return ResponseEntity.notFound().build();

    }

    @Override
    public ResponseEntity delete(Long id) {

        Optional<News> news = Optional.ofNullable(newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("A news %s não foi encontrada", id))));

        if(news.isPresent()){
            newsRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
    
}
