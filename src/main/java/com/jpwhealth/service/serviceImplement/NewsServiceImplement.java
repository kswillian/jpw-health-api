package com.jpwhealth.service.serviceImplement;

import com.jpwhealth.configuration.exception.ResourceNotFoundException;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return NewsDetailedDto.convertModelToDto(newsList);
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        verifyIfNewsExists(id);
        Optional<News> news = newsRepository.findById(id);
        return ResponseEntity.ok().body(new NewsDetailedDto(news.get(), news.get().getTopics()));
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
        verifyIfNewsExists(newsFormUpdate.getId());
        verifyIfTopicNewsExists(newsFormUpdate.getTopicId());
        List<Topic> topics = topicRepository.findAllById(newsFormUpdate.getTopicId());
        News newsUpdate = NewsFormUpdate.convertFormToModel(newsFormUpdate, topics);
        newsRepository.save(newsUpdate);
        return ResponseEntity.ok().body(new NewsDto(newsUpdate));
    }

    @Override
    public ResponseEntity delete(Long id) {
        verifyIfNewsExists(id);
        newsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private void verifyIfNewsExists(Long id){
        if(!newsRepository.findById(id).isPresent()){
            throw new ResourceNotFoundException("News", id);
        }
    }

    private void verifyIfTopicNewsExists(List<Long> ids){
        if(topicRepository.findAllById(ids).isEmpty()){
            throw new ResourceNotFoundException("Topic", ids);
        }
    }

}
