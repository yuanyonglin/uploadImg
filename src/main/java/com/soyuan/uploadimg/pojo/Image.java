package com.soyuan.uploadimg.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @ Author     ：yuanyl.
 * @ Date       ：Created in 10:06 2019/1/7
 */
@Data
public class Image {
    private String id;
    private String imageURL;
    private String imageName;
    private Timestamp imageDate;
    private String imageOriginalName;
    private String imageType;

}
