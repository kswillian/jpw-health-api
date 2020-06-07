package com.jpwhealth.repository;

import com.jpwhealth.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    Boolean existsByName(String name);

}
