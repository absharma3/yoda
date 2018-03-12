package com.yoda.repository;

import com.yoda.models.ImageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by abhimanyus on 3/6/18.
 */
public interface ImageRepository {

    ImageInfo save(String articleId, MultipartFile image) throws IllegalStateException, IOException;
    ImageInfo getImageInfo(String articleId);

}
