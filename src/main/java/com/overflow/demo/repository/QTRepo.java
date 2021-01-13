package com.overflow.demo.repository;

import com.overflow.demo.models.QuestionTag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QTRepo extends CrudRepository<QuestionTag,Long> {
}
