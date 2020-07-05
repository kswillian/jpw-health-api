package com.jpwhealth.validation;

import com.jpwhealth.configuration.exception.ResourceNotFoundException;
import com.jpwhealth.domain.Entity;
import com.jpwhealth.repository.FamilyRepository;
import com.jpwhealth.repository.NewsRepository;
import com.jpwhealth.repository.TopicRepository;

import java.util.List;

public class RecordValidation {

    private FamilyRepository familyRepository;
    private TopicRepository topicRepository;
    private NewsRepository newsRepository;

    public RecordValidation(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    public RecordValidation(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public RecordValidation(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public void verifyIfRecordExist(Entity entity, Long id){

        switch (entity){
            case Family:
                if(!familyRepository.findById(id).isPresent()){
                    throw new ResourceNotFoundException(Entity.Family, id);
                }
                break;
            case Topic:
                if(!topicRepository.findById(id).isPresent()){
                    throw new ResourceNotFoundException(Entity.Topic, id);
                }
                break;
            case News:
                if(!newsRepository.findById(id).isPresent()){
                    throw new ResourceNotFoundException(Entity.News, id);
                }
                break;
        }

    }

    public void verifyIfRecordExist(Entity entity, List<Long> ids){

        switch (entity){
            case Family:
                if(familyRepository.findAllById(ids).isEmpty()){
                    throw new ResourceNotFoundException(Entity.Family, ids);
                }
                break;
            case Topic:
                if(topicRepository.findAllById(ids).isEmpty()){
                    throw new ResourceNotFoundException(Entity.Topic, ids);
                }
                break;
            case News:
                if(newsRepository.findAllById(ids).iterator().hasNext()){
                    throw new ResourceNotFoundException(Entity.News, ids);
                }
                break;
        }

    }

}
