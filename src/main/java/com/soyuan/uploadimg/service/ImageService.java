package com.soyuan.uploadimg.service;

import com.soyuan.uploadimg.pojo.Image;


/**
 * @ Author     ：yuanyl.
 * @ Date       ：Created in 14:36 2019/1/7
 */
public interface ImageService {
     void save(Image image);

     String  queryAll();

     Image queryById(Image image);
}
