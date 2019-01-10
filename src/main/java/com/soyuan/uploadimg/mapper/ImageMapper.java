package com.soyuan.uploadimg.mapper;

import com.soyuan.uploadimg.pojo.Image;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ Author     ：yuanyl.
 * @ Date       ：Created in 14:21 2019/1/7
 */

public interface ImageMapper {

    @Insert("insert into image(id,ImageURL,ImageName,ImageDate,ImageOriginalName,ImageType) values (#{id},#{imageURL},#{imageName},#{imageDate},#{imageOriginalName},#{imageType})")
    public void save (Image image);

    @Select("select ImageURL from image order by ImageDate desc")
    public List<Image> queryAll();
}
