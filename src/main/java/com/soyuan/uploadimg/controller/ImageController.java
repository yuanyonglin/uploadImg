package com.soyuan.uploadimg.controller;

import com.soyuan.uploadimg.pojo.Image;
import com.soyuan.uploadimg.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author     ：yuanyl.
 * @ Date       ：Created in 10:18 2019/1/7
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class ImageController {

    @Autowired
    ImageService imageService;

    /**
     * 此接口用来上传图片
     *
     * @param inputFile
     * @return
     * @throws IOException
     */

 /*   @Value("${upload.path}")
    String path;*/
    @PostMapping("/file/uploading")
    public HttpStatus fileUpload(@RequestParam(required = false) MultipartFile inputFile, HttpServletRequest request) throws IOException {
        InputStream is = inputFile.getInputStream();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        Long id = new Date().getTime();
        //得到文件的原始名
        String imageOriginalFilename = inputFile.getOriginalFilename();
        //根路径拼接 拼接成指定格式，方便创建
        String filepath = request.getServletContext().getRealPath("/") + "staticFilesUploads/images/" + date;
        //得到文件命名，并从.开始截取 拼接id成为新的文件名
        String filename = String.valueOf(id) + imageOriginalFilename.substring(imageOriginalFilename.indexOf("."));
        String path = "staticFilesUploads/images/" + date;
        //根据路径创建文件夹
        log.info(filepath);
        new File(filepath).mkdir();
        OutputStream os = new FileOutputStream(new File(filepath + "/" + filename));
        IOUtils.copy(is, os);
        Image image = new Image();
        image.setId(String.valueOf(id));
        image.setImageDate(new Timestamp(id));
        image.setImageName(filename);
        image.setImageOriginalName(imageOriginalFilename);
        image.setImageType(imageOriginalFilename.substring(imageOriginalFilename.indexOf(".") + 1));

        image.setImageURL("/" + ((filepath + filename).substring(44,78))+"/"+filename);
        log.info("----------connnnnn");
        imageService.save(image);
        return HttpStatus.OK;
    }


    /**
     * 查询图片url接口
     */
    @GetMapping(value = "/queryAll")
    public String listImage() {
        String allImage = imageService.queryAll();
        log.info("返回所有:{}", allImage);
        return allImage;
    }


    @GetMapping(value = "queryById")
    public Image queryImageById(Image image){
        Image images = imageService.queryById(image);
        return images;
    }
}
