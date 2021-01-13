package com.overflow.demo.repository;

import com.overflow.demo.models.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends CrudRepository<Question,Long>{

    List<Question> findAll();





}
