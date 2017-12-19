package com.yoda.controllers;

import com.yoda.models.AdminUser;
import com.yoda.models.NormalUser;
import com.yoda.models.QueryResolver;
import com.yoda.models.User;
import com.yoda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.core.Context;

/**
 * Created by abhimanyus on 12/19/17.
 */
@Controller
@RequestMapping("api/user")
public class UserController {


    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "/add" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User addUser(@RequestBody NormalUser user){

        return userRepository.save(user);
    }

    @RequestMapping(path = "/add/admin" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User addAdmin(@RequestBody AdminUser user){
        return userRepository.save(user);
    }


    @RequestMapping(path = "/add/resolver" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User addUser(@RequestBody QueryResolver user){
        return userRepository.save(user);
    }


}
