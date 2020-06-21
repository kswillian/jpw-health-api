package com.jpwhealth.service;

import com.jpwhealth.domain.News;
import com.jpwhealth.domain.dto.NewsDto;
import com.jpwhealth.domain.form.NewsForm;
import com.jpwhealth.domain.form.NewsFormUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface NewsService {

    Page<News> getAll(Pageable pageable);

    ResponseEntity<?> getById(Long id);

    News register(NewsForm newsForm);

    ResponseEntity<NewsDto> update(NewsFormUpdate newsFormUpdate);

    ResponseEntity delete(Long id);

}
