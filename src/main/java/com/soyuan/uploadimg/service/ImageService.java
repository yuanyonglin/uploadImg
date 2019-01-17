package com.soyuan.uploadimg.service;

import com.soyuan.uploadimg.pojo.Image;

import java.util.List;


/**
 * @ Author     ：yuanyl.
 * @ Date       ：Created in 14:36 2019/1/7
 */
public interface ImageService {
    void save(Image image);

    List<Image> queryAll();

    Image queryById(String id);

    void modifyImgType(String id, String imageType);

    Image queryByType(String imageType);

    List<Image> queryByDate();

    void deleteImageById(String id);
}
