package com.jpwhealth.service.serviceImplement;

import com.jpwhealth.configuration.exception.TopicAlreadyRegisteredException;
import com.jpwhealth.domain.Entity;
import com.jpwhealth.domain.Topic;
import com.jpwhealth.domain.dto.TopicDetailedDto;
import com.jpwhealth.domain.dto.TopicDto;
import com.jpwhealth.domain.dto.converter.ConverterModelToDto;
import com.jpwhealth.domain.form.TopicForm;
import com.jpwhealth.domain.form.TopicFormUpdate;
import com.jpwhealth.domain.form.converter.ConverterFormToModel;
import com.jpwhealth.repository.TopicRepository;
import com.jpwhealth.service.TopicService;
import com.jpwhealth.validation.RecordValidation;
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
        return ConverterModelToDto.toTopicDetailedDto(topics);
    }

    @Override
    public ResponseEntity<TopicDto> getById(Long id) {
        new RecordValidation(topicRepository).verifyIfRecordExist(Entity.Topic, id);
        Optional<Topic> topic = topicRepository.findById(id);
        return ResponseEntity.ok().body(ConverterModelToDto.toTopicDto(topic.get()));
    }

    @Override
    public Topic register(TopicForm topicForm) {
        verifyIfTopicExists(topicForm.getName());
        Topic topic = ConverterFormToModel.toTopic(topicForm);
        topicRepository.save(topic);
        return topic;
    }

    @Override
    public ResponseEntity<TopicDto> update(TopicFormUpdate topicFormUpdate) {
        new RecordValidation(topicRepository).verifyIfRecordExist(Entity.Topic, topicFormUpdate.getId());
        verifyIfTopicExists(topicFormUpdate.getName());
        Topic topicUpdate = ConverterFormToModel.toTopic(topicFormUpdate);
        topicRepository.save(topicUpdate);
        return ResponseEntity.ok().body(new TopicDto(topicUpdate));
    }

    @Override
    public ResponseEntity delete(Long id) {
        new RecordValidation(topicRepository).verifyIfRecordExist(Entity.Topic, id);
        topicRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private void verifyIfTopicExists(String topicName){
        if(topicRepository.existsByName(topicName)){
            throw new TopicAlreadyRegisteredException(topicName);
        }
    }

}
