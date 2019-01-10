package com.soyuan.uploadimg.service;

import com.soyuan.uploadimg.pojo.Image;

import java.util.List;

/**
 * @ Author     ：yuanyl.
 * @ Date       ：Created in 14:36 2019/1/7
 */
public interface ImageService {
    public void save(Image image);

    public List<Image> queryAll();
}
