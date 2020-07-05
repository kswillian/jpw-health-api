package com.jpwhealth.service.serviceImplement;

import com.jpwhealth.domain.Entity;
import com.jpwhealth.domain.News;
import com.jpwhealth.domain.Topic;
import com.jpwhealth.domain.dto.NewsDto;
import com.jpwhealth.domain.dto.converter.ConverterModelToDto;
import com.jpwhealth.domain.form.NewsForm;
import com.jpwhealth.domain.form.NewsFormUpdate;
import com.jpwhealth.domain.form.converter.ConverterFormToModel;
import com.jpwhealth.repository.NewsRepository;
import com.jpwhealth.repository.TopicRepository;
import com.jpwhealth.service.NewsService;
import com.jpwhealth.validation.RecordValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<News> getAll(Pageable pageable) {
        Page<News> newsList = newsRepository.findAll(pageable);
        return ConverterModelToDto.toNewsDetailedDto(newsList);
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        new RecordValidation(newsRepository).verifyIfRecordExist(Entity.News, id);
        Optional<News> news = newsRepository.findById(id);
        return ResponseEntity.ok().body(ConverterModelToDto.toNewsDto(news.get()));
    }

    @Override
    public News register(NewsForm newsForm) {
        List<Topic> topics = topicRepository.findAllById(newsForm.getTopicId());
        News news = ConverterFormToModel.toNews(newsForm, topics);
        newsRepository.save(news);
        return news;
    }

    @Override
    public ResponseEntity<NewsDto> update(NewsFormUpdate newsFormUpdate) {
        new RecordValidation(newsRepository).verifyIfRecordExist(Entity.News, newsFormUpdate.getId());
        new RecordValidation(topicRepository).verifyIfRecordExist(Entity.Topic, newsFormUpdate.getTopicId());
        News newsUpdate = ConverterFormToModel.toNews(newsFormUpdate, topicRepository.findAllById(newsFormUpdate.getTopicId()));
        newsRepository.save(newsUpdate);
        return ResponseEntity.ok().body(ConverterModelToDto.toNewsDto(newsUpdate));
    }

    @Override
    public ResponseEntity delete(Long id) {
        new RecordValidation(newsRepository).verifyIfRecordExist(Entity.News, id);
        newsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
