package com.soyuan.uploadimg.controller;

import com.soyuan.uploadimg.pojo.Image;
import com.soyuan.uploadimg.service.ImageService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ Author     ：yuanyl.
 * @ Date       ：Created in 10:18 2019/1/7
 */
@RestController
@RequestMapping("/users")
public class ImageController {

    @Autowired
    ImageService imageService;

    /**
     * 此接口用来上传图片
     * @param inputFile
     * @return
     * @throws IOException
     */
    @RequestMapping("/file/uploading")
    public String fileUpload(@RequestParam(required=false) MultipartFile inputFile) throws IOException {
        InputStream is = inputFile.getInputStream();

        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        Long id = new Date().getTime();

        //得到文件的原始名
        String imageOriginalFilename = inputFile.getOriginalFilename();
        //得到路径，并按照规则拼接起来
        String filepath = "E:/idea-workspace/uploadimg/src/main/resources/staticFilesUploads/images/"+date+"/";
        //得到文件命名，并从.开始截取 拼接id成为新的文件名
        String filename = String.valueOf(id)+imageOriginalFilename.substring(imageOriginalFilename.indexOf("."));
        //根据路径创建文件夹
        new File(filepath).mkdir();

        OutputStream os = new FileOutputStream(new File(filepath + "/" + filename));

        IOUtils.copy(is,os);

        Image image = new Image();
        image.setId(String.valueOf(id));
        image.setImageDate(new Timestamp(id));
        image.setImageName(filename);
        image.setImageOriginalName(imageOriginalFilename);
        image.setImageType(imageOriginalFilename.substring(imageOriginalFilename.indexOf(".")+1));
        image.setImageURL((filepath+filename).substring(46));
        System.out.println("----------connnnnn");
        imageService.save(image);
        return "ok";
    }


    /**
     *  查询图片url接口
     */
    @RequestMapping("/queryAll")
    public List listImage(){
        List<Image> images = imageService.queryAll();
        for (Image image: images) {
            image.setImageURL(image.getImageURL());
        }
        return images;
    }

}
