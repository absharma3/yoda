package com.yoda.controllers;

import com.yoda.models.Question;
import com.yoda.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * Created by abhimanyus on 12/18/17.
 * **FEATURES**
 * 1) add question
 * 2) add comment
 * 3) delete comment(not required right now)
 * 4) edit question
 * 5) add answer
 *
 *
 */

@Controller
@RequestMapping("/api/question")
public class QuestionController  {


    @Autowired
    QuestionRepository questionRepository;

    @RequestMapping(path = "/add/{userId}/{questionString}" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Question askQuestion(@PathVariable String questionString, @PathVariable String userId){


        //TODO add a user validation
        Question question =  new Question();
        question.setUserId(userId);
        question.setQuestionId(UUID.randomUUID().toString());
        return questionRepository.save(question);

    }


    @RequestMapping(path = "/comment/{userId}/{questionId}/{comment}" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Question addComment(@PathVariable String questionId, @PathVariable String userId, @PathVariable String comment){

        //TODO add a user validation
        Question question = questionRepository.findOne(questionId);
        question.addComment(comment);
        return questionRepository.save(question);

    }


    @RequestMapping(path = "/{questionId}/{userId}/{answer}" , method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Question answer(@PathVariable String questionId, @PathVariable String userId, @PathVariable String answer){

        //TODO add a user validation
        Question question = questionRepository.findOne(questionId);
        question.setAnswerString(answer);
        return questionRepository.save(question);

    }

}
