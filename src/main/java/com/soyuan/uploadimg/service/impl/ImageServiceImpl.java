package com.soyuan.uploadimg.service.impl;

import com.soyuan.uploadimg.mapper.ImageMapper;
import com.soyuan.uploadimg.pojo.Image;
import com.soyuan.uploadimg.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Author     ：yuanyl.
 * @ Date       ：Created in 14:37 2019/1/7
 */
@Service
@Transactional(readOnly = true)
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageMapper imageMapper;

    @Transactional(readOnly = false)
    @Override
    public void save(Image image) {
        System.out.println("serrt-----------------------------------------");
        imageMapper.save(image);
    }

    @Override
    public List<Image> queryAll() {
        return imageMapper.queryAll();
    }
}
