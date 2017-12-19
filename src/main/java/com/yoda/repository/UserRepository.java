package com.yoda.repository;

import com.yoda.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by abhimanyus on 12/19/17.
 */
public interface UserRepository extends MongoRepository<User, String> {
}
