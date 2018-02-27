package com.yoda.controllers;

import com.yoda.models.AdminUser;
import com.yoda.models.NormalUser;
import com.yoda.models.QueryResolver;
import com.yoda.models.User;
import com.yoda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Context;
import java.util.UUID;

/**
 * Created by abhimanyus on 12/19/17.
 * This class is responsible for handling all the transactions related to user management.
 *
 * Current added functionality
 * User creation
 * Admin creation
 * Query resolver creation
 * Fetching user based on id
 *
 *
 * TODO user fetch based on email
 *
 */
@Controller
@RequestMapping("api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "/user" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User addUser(@RequestBody NormalUser user){
       return this.add(user);
    }

    @RequestMapping(path = "/user/admin" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User addAdmin(@RequestBody AdminUser user){
        return this.add(user);
    }


    @RequestMapping(path = "/user/resolver" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User addUser(@RequestBody QueryResolver user){
        return this.add(user);
    }


    @RequestMapping(path = "/user/{userId}" , method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User find(@PathVariable String userId){
        return userRepository.findOne(userId);
    }

    private User add(User user){
        //TODO Add validations on email and password
        //TODO Add validation if the email already exist
        user.setUserId(UUID.randomUUID());
        return userRepository.save(user);
    }

}
