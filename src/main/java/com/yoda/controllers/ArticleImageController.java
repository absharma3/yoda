package com.yoda.controllers;

import com.yoda.com.yoda.NotYetImplemented;
import com.yoda.models.Article;
import com.yoda.models.ImageInfo;
import com.yoda.repository.ArticleRepository;
import com.yoda.repository.ImageRepository;
import com.yoda.repository.ImageRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.FormParam;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.PathParam;
import java.io.IOException;

/**
 * Created by abhimanyus on 3/5/18.
 */
@Controller
@RequestMapping(path = "/api/article/image")
public class ArticleImageController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ImageRepositoryImpl imageRepository;

    @RequestMapping(path = "/{articleId}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ImageInfo uploadImageForArticle(@RequestParam MultipartFile image, @PathVariable String articleId) throws IOException {

        Assert.notNull(image, "Image can not be null");
        ImageInfo imageInfo = imageRepository.save(articleId, image);
        //TODO also update image info into the article
        Article article = articleRepository.findOne(articleId);
        article.setImageInfo(imageInfo);
        articleRepository.save(article);
        return imageInfo;


    }

    @RequestMapping(path = "/{articleId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ImageInfo fetchImageForArticle(@PathVariable String articleId) throws IOException{
        Assert.notNull(articleId, "Article ID can not be null");
        return null;
    }

}
