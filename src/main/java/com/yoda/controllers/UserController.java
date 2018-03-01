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
import java.util.List;
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
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User addUser(@RequestBody NormalUser user){
       return this.add(user);
    }

    @RequestMapping(path = "/admin" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User addAdmin(@RequestBody AdminUser user){
        return this.add(user);
    }


    @RequestMapping(path = "/resolver" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User addResolver(@RequestBody QueryResolver user){
        return this.add(user);
    }


    @RequestMapping(path = "/{userId}" , method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User find(@PathVariable String userId){
        return userRepository.findOne(userId);
    }

    private User add(User user){
        //TODO Add validations on email and password
        //TODO Add validation if the email already exist
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User getUserByEmail(@RequestBody NormalUser userCredentials){

        List<User> users = userRepository.getByEmailAndPassword(userCredentials.getEmail(), userCredentials.getPassword());
        for(User user : users) {
            if (user.getPassword().equals(userCredentials.getPassword())) {
                return user;
            }
        }
        return null;

    }

}
