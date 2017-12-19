package com.yoda.repository;

import com.yoda.models.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by abhimanyus on 12/18/17.
 */
public interface QuestionRepository extends MongoRepository<Question, String> {



}
