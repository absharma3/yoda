package com.yoda.repository;

import com.yoda.models.Joke;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by abhimanyus on 3/6/18.
 */
public interface JokeRepository extends MongoRepository<Joke, String> {
}
