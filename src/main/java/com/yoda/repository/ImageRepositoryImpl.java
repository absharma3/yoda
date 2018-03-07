package com.yoda.repository;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.yoda.models.ImageInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by abhimanyus on 3/6/18.
 */

@Component
public class ImageRepositoryImpl implements ImageRepository {


    private AmazonS3 s3client;
    private String bucketName = "images-yoda";
    private AWSCredentials credentials = new BasicAWSCredentials(
            "accessKey",
            "secretKey"
    );
    private String region = "https://s3.ap-south-1.amazonaws.com/";

    public ImageRepositoryImpl() {
         s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.AP_SOUTH_1)
                .build();

    }

    public ImageInfo save(String articleId, MultipartFile image) throws IllegalStateException, IOException {
        InputStream stream = image.getInputStream();
        String key = articleId + image.getOriginalFilename();
        AccessControlList acl = new AccessControlList();
        acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, stream, new ObjectMetadata()).withAccessControlList(acl);
        PutObjectResult result = this.s3client.putObject(putObjectRequest);
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.setBucketName(bucketName);
        imageInfo.setImageName(image.getName());
        imageInfo.setKey(key);
        imageInfo.seteTag(result.getETag());
        imageInfo.buildLink(this.region);
        return imageInfo;

    }

    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException
    {
        File convFile = new File( multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }
}
