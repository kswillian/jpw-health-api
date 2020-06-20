package com.jpwhealth.service.serviceImplement;

import com.jpwhealth.configuration.exception.ResourceNotFoundException;
import com.jpwhealth.configuration.exception.TopicAlreadyRegisteredException;
import com.jpwhealth.domain.Topic;
import com.jpwhealth.domain.dto.TopicDetailedDto;
import com.jpwhealth.domain.dto.TopicDto;
import com.jpwhealth.domain.form.TopicForm;
import com.jpwhealth.domain.form.TopicFormUpdate;
import com.jpwhealth.repository.TopicRepository;
import com.jpwhealth.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImplement implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<TopicDetailedDto> getAll() {
        List<Topic> topics = topicRepository.findAll();
        return TopicDetailedDto.convertModelToDto(topics);
    }

    @Override
    public ResponseEntity<TopicDetailedDto> getById(Long id) {
        verifyIfTopicExists(id);
        Optional<Topic> topic = topicRepository.findById(id);
        return ResponseEntity.ok().body(new TopicDetailedDto(topic.get()));
    }

    @Override
    public Topic register(TopicForm topicForm) {
        verifyIfTopicExists(topicForm.getName());
        Topic topic = TopicForm.convertFormToModel(topicForm);
        topicRepository.save(topic);
        return topic;
    }

    @Override
    public ResponseEntity<TopicDto> update(TopicFormUpdate topicFormUpdate) {
        verifyIfTopicExists(topicFormUpdate.getId());
        verifyIfTopicExists(topicFormUpdate.getName());
        Topic topicUpdate = TopicFormUpdate.convertFormToModel(topicFormUpdate);
        topicRepository.save(topicUpdate);
        return ResponseEntity.ok().body(new TopicDto(topicUpdate));
    }

    @Override
    public ResponseEntity delete(Long id) {
        verifyIfTopicExists(id);
        topicRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private void verifyIfTopicExists(Long id){
        if(!topicRepository.findById(id).isPresent()){
            throw new ResourceNotFoundException("Topic", id);
        }
    }

    private void verifyIfTopicExists(String topicName){
        if(topicRepository.existsByName(topicName)){
            throw new TopicAlreadyRegisteredException(topicName);
        }
    }

}
