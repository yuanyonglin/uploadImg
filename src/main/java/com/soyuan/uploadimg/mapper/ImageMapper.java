package com.soyuan.uploadimg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soyuan.uploadimg.pojo.Image;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ Author     ：yuanyl.
 * @ Date       ：Created in 14:21 2019/1/7
 */

public interface ImageMapper extends BaseMapper<Image> {
    // @Insert(" insert into image(id,ImageURL,ImageName,ImageDate,ImageOriginalName,ImageType) values (#{id},#{imageURL},#{imageName},#{imageDate},#{imageOriginalName},#{imageType})")
    void save(Image image);

   // List<Image> queryAll();

    Image queryById(String id);

    void modifyImgType(@Param("id") String id, @Param("imageType") String imageType);

    Image queryByType(String imageType);

    List<Image> queryByDate();

    void deleteImageById(String id);
}
