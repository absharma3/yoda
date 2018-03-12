package com.yoda.controllers;

import com.yoda.models.Joke;
import com.yoda.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;

/**
 * Created by abhimanyus on 3/6/18.
 */
@Controller
@RequestMapping(path = "/api/joke")
public class JokeController {

    @Autowired
    private JokeRepository jokeRepository;

    @RequestMapping(path = "", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Joke addJoke(@RequestBody Joke joke) {
        return jokeRepository.save(joke);
    }

    @RequestMapping(path = "/{jokeId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Joke findJoke(@RequestParam String jokeId) {
        return jokeRepository.findOne(jokeId);
    }

    @RequestMapping(path = "/{jokeId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody void deleteJoke(@RequestParam String jokeId) {
         jokeRepository.delete(jokeId);
    }

}
