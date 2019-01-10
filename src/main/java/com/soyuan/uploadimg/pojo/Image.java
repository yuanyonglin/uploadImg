package com.soyuan.uploadimg.pojo;

import java.sql.Timestamp;

/**
 * @ Author     ：yuanyl.
 * @ Date       ：Created in 10:06 2019/1/7
 */
public class Image {
    private String id;
    private String imageURL;
    private String imageName;
    private Timestamp imageDate;
    private String imageOriginalName;
    private String imageType;

    public Image() {
    }

    public Image(String id, String imageURL, String imageName, Timestamp imageDate, String imageOriginalName, String imageType) {
        this.id = id;
        this.imageURL = imageURL;
        this.imageName = imageName;
        this.imageDate = imageDate;
        this.imageOriginalName = imageOriginalName;
        this.imageType = imageType;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Timestamp getImageDate() {
        return imageDate;
    }

    public void setImageDate(Timestamp imageDate) {
        this.imageDate = imageDate;
    }

    public String getImageOriginalName() {
        return imageOriginalName;
    }

    public void setImageOriginalName(String imageOriginalName) {
        this.imageOriginalName = imageOriginalName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id='" + id + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", imageName='" + imageName + '\'' +
                ", imageDate=" + imageDate +
                ", imageOriginalName='" + imageOriginalName + '\'' +
                ", imageType='" + imageType + '\'' +
                '}';
    }
}
