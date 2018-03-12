package com.yoda.repository;

import com.yoda.models.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by abhimanyus on 12/18/17.
 */
public interface QuestionRepository extends MongoRepository<Question, String> {
    List<Question> findByUserId(String userId);
}
