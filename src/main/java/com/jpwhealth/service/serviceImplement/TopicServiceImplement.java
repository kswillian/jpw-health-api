package com.jpwhealth.service.serviceImplement;

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

        Optional<Topic> topic = Optional.ofNullable(topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("O topico %s não foi encontrado", id))));

        if(topic.isPresent()){
            return ResponseEntity.ok().body(new TopicDetailedDto(topic.get()));
        }

        return ResponseEntity.notFound().build();

    }

    @Override
    public Topic register(TopicForm topicForm) {

        if(topicRepository.existsByName(topicForm.getName())){
            throw new RuntimeException(
                    String.format("O topico %s já se encontra cadastrado!", topicForm.getName())
            );
        }

        Topic topic = TopicForm.convertFormToModel(topicForm);
        topicRepository.save(topic);

        return topic;

    }

    @Override
    public ResponseEntity<TopicDto> update(TopicFormUpdate topicFormUpdate) {

        Optional<Topic> topic = Optional.ofNullable(topicRepository.findById(topicFormUpdate.getId())
                .orElseThrow(() -> new RuntimeException("Topico não encontrado.")));

        if(topic.isPresent()){
            Topic topicUpdate = TopicFormUpdate.convertFormToModel(topicFormUpdate);
            topicRepository.save(topicUpdate);
            return ResponseEntity.ok().body(new TopicDto(topicUpdate));
        }

        return ResponseEntity.notFound().build();

    }

    @Override
    public ResponseEntity delete(Long id) {

        Optional<Topic> topic = Optional.ofNullable(topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("O topico %s não foi encontrado", id))));

        if(topic.isPresent()){
            topicRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }
}
