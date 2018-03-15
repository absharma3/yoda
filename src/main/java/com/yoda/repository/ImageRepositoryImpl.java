package com.yoda.repository;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.yoda.models.ImageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by abhimanyus on 3/6/18.
 */

@Component
public class ImageRepositoryImpl implements ImageRepository {



    private AmazonS3 s3client;

    @Value("${aws.image.bucket}")
    private String bucketName;

    @Value("${aws.image.region}")
    private String region;

    @Value("${aws.access.key.id}")
    private String accessKey;

    @Value("${aws.secret.key}")
    private String secretKey;

    public ImageRepositoryImpl() {

        s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey,secretKey)))
                .withRegion(Regions.AP_SOUTH_1)
                .build();

    }

    @Override
    public ImageInfo save(String articleId, MultipartFile image) throws IllegalStateException, IOException {
        InputStream stream = image.getInputStream();

        //Key should be unique per article
        String key = articleId + image.getOriginalFilename();
        //Grant permission to all the users to view the file
        AccessControlList acl = new AccessControlList();
        acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);

        //Uploading data to S3 bucket
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, stream, new ObjectMetadata()).withAccessControlList(acl);
        PutObjectResult result = this.s3client.putObject(putObjectRequest);

        //Creating return object with appropriate data
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.setBucketName(bucketName);
        imageInfo.setImageName(image.getName());
        imageInfo.setKey(key);
        imageInfo.seteTag(result.getETag());

        //Link to access image uploaded to s3
        imageInfo.buildLink(this.region);
        return imageInfo;

    }

    @Override
    public ImageInfo getImageInfo(String articleId) {

        //TODO should be able to fetch image based on key
        return null;
    }

    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException
    {
        File convFile = new File( multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }


}
