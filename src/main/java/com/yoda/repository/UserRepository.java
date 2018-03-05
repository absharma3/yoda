package com.yoda.repository;

import com.yoda.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by abhimanyus on 12/19/17.
 */
public interface UserRepository extends MongoRepository<User, String> {

    /**
     *
     * @param email id for which the user has to be fetched from database.
     * @return  can return a null or a User which has
     */
     User getByEmailAndPassword(String email, String password);
     User getByEmail(String email);



}
