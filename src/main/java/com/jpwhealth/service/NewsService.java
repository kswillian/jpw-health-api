package com.jpwhealth.service;

import com.jpwhealth.domain.News;
import com.jpwhealth.domain.dto.NewsDetailedDto;
import com.jpwhealth.domain.dto.NewsDto;
import com.jpwhealth.domain.form.NewsForm;
import com.jpwhealth.domain.form.NewsFormUpdate;
import com.jpwhealth.domain.form.TopicFormUpdate;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NewsService {

    List<News> getAll();

    ResponseEntity<?> getById(Long id);

    News register(NewsForm newsForm);

    ResponseEntity<NewsDto> update(NewsFormUpdate newsFormUpdate);

    ResponseEntity delete(Long id);

}
