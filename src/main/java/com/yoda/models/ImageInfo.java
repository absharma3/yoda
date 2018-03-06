package com.yoda.models;

/**
 * Created by abhimanyus on 3/6/18.
 */
public class ImageInfo {

    private String imageName;
    private String bucketName;
    private String eTag;
    private String key;
    private String link;



    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String geteTag() {
        return eTag;
    }

    public void seteTag(String eTag) {
        this.eTag = eTag;
    }

    public void buildLink(String region) {
        this.link = region + bucketName + "/" + this.key;
    }

    public String getLink() {
        return link;
    }
}
