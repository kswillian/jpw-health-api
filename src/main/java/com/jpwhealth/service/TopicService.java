package com.jpwhealth.service;

import com.jpwhealth.domain.Topic;
import com.jpwhealth.domain.dto.TopicDetailedDto;
import com.jpwhealth.domain.dto.TopicDto;
import com.jpwhealth.domain.form.TopicForm;
import com.jpwhealth.domain.form.TopicFormUpdate;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TopicService {

    List<TopicDto> getAll();

    ResponseEntity<TopicDetailedDto> getById(Long id);

    Topic register(TopicForm topicForm);

    ResponseEntity<TopicDto> update(TopicFormUpdate topicFormUpdate);

    ResponseEntity delete(Long id);

}
