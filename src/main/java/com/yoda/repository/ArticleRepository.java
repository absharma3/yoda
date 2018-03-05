package com.yoda.repository;

import com.yoda.models.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by abhimanyus on 3/5/18.
 */
public interface ArticleRepository extends MongoRepository<Article, String> {
}
