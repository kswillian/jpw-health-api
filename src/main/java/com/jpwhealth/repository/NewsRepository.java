package com.jpwhealth.repository;

import com.jpwhealth.domain.News;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NewsRepository extends PagingAndSortingRepository<News, Long> {

}
