package com.yoda.controllers;

import com.yoda.models.Article;
import com.yoda.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(path = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<Article> articles() {
        return articleRepository.findAll();
    }

    @RequestMapping(path = "/{articleId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Article article(@PathVariable String articleId) {
        return articleRepository.findOne(articleId);
    }


}
