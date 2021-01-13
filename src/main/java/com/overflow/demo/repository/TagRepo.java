package com.overflow.demo.repository;

import com.overflow.demo.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepo extends CrudRepository<Tag,Long> {
    List<Tag> findAll();
}
