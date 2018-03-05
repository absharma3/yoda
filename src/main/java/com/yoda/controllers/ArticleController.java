package com.yoda.controllers;

import com.yoda.models.Article;
import com.yoda.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by abhimanyus on 2/27/18.
 */

@Controller
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping(path = "", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Article addArticle(@RequestBody Article article) {
        return articleRepository.save(article);
    }


}
