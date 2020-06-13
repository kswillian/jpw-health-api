package com.jpwhealth.service;

import com.jpwhealth.domain.News;
import com.jpwhealth.domain.dto.NewsDto;
import com.jpwhealth.domain.form.NewsForm;
import com.jpwhealth.domain.form.NewsFormUpdate;
import com.jpwhealth.domain.form.TopicFormUpdate;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NewsService {

    List<NewsDto> getAll();

    ResponseEntity<?> getById(Long id);

    News register(NewsForm newsForm);

    ResponseEntity<NewsDto> update(Long id, NewsFormUpdate newsFormUpdate);

    ResponseEntity delete(Long id);

}
