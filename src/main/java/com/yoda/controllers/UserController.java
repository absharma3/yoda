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
 * Update user password based on email
 * Update existing user object
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
        return userRepository.save(user);
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User getUserByEmail(@RequestBody NormalUser userCredentials){
        //Ideally there should not be a condition where multiple users can have the same credentials but in case we have
        //there should be a way to handle it
        return userRepository.getByEmailAndPassword(userCredentials.getEmail(), userCredentials.getPassword());

    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User updateUser(@PathVariable String userId, @RequestBody NormalUser newUserDetail){

        //TODO have to figure out if in case user role has to be changed how to accommodate that
        User previousUserDetail = userRepository.findOne(userId);
        previousUserDetail.setEmail(newUserDetail.getEmail());
        previousUserDetail.setAddress(newUserDetail.getAddress());
        previousUserDetail.setPassword(newUserDetail.getPassword());
        return userRepository.save(previousUserDetail);
    }

    @RequestMapping(path = "/email/{email}/{updatedPassword}", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User updateUser(@PathVariable String email, @PathVariable String updatedPassword){
        User user = userRepository.getByEmail(email);
        user.setPassword(updatedPassword);
        return userRepository.save(user);
    }

}
