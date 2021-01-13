package com.overflow.demo.repository;

import com.overflow.demo.models.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AnswerRepo extends CrudRepository<Answer,Long> {
    List<Answer> findAll();
}
