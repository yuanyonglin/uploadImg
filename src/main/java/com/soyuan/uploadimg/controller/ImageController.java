package com.soyuan.uploadimg.controller;

import com.soyuan.uploadimg.pojo.Image;
import com.soyuan.uploadimg.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
        String contextPath = System.getProperty("user.dir");
        String filepath= contextPath+"/src/main/resources/staticFilesUploads/images/"+date;
        //得到文件命名，并从.开始截取 拼接id成为新的文件名
        String filename = String.valueOf(id) + imageOriginalFilename.substring(imageOriginalFilename.indexOf("."));
        //根据路径创建文件夹
        log.info(filepath);
        new File(filepath).mkdirs();
        OutputStream os = new FileOutputStream(new File(filepath + "/" + filename));
        IOUtils.copy(is, os);
        Image image = new Image();
        image.setId(String.valueOf(id));
        image.setImageDate(new Timestamp(id));
        image.setImageName(filename);
        image.setImageOriginalName(imageOriginalFilename);
        image.setImageType(imageOriginalFilename.substring(imageOriginalFilename.indexOf(".") + 1));
        image.setImageURL(((filepath + filename).substring(46,81))+"/"+filename);
        log.info("----------connnnnn");
        imageService.save(image);
        return HttpStatus.OK;
    }



    /**
     * 查询图片url接口
     */
    @GetMapping(value = "/queryAll")
    public List<Image> listImage() {
        List<Image> images = imageService.queryAll();
        log.info("返回所有:{}", images);
        return images;
    }

    /**
     *
     * @param id
     * @return images
     * 此方法根据id查询其余数据
     */

    @GetMapping(value = "queryById")
    public Image queryImageById(String id){
        Image images = imageService.queryById(id);
        return images;
    }


    /**
     *
     * @param id
     * @param imageType
     * @return 此方法用来更新imagetype
     */
    @PostMapping(value = "/updateImageType")
    public HttpStatus updateImageType(String id,String imageType){
        Image image = imageService.queryById(id);
    //    String imageType = image.getImageType();
        imageService.modifyImgType(id,imageType);
        return HttpStatus.OK;
    }


    /**
     *
     * @param imageType
     * @return  数据库根据ImageType查询图片路径并返回给前端，用作前端不同页面位置的展示。
     */
    @GetMapping(value = "/queryByType")
    public Image queryByType(String imageType){
        Image image = imageService.queryByType(imageType);
        return image;
    }

    /**
     *
     * @return 数据库根据ImageDate查询图片路径并返回给前端，结果为近三天上传的图片。
     */
    @GetMapping(value = "/queryByDate")
    public List<Image> queryByDate(){
        List<Image> images = imageService.queryByDate();
        return images;
    }

    /**
     *
     * @param id
     * @return   根据id删除图片
     */
    @RequestMapping(value = "/deleteImageById")
    public HttpStatus deleteImageById(String id){
        imageService.deleteImageById(id);
        return HttpStatus.OK;
    }
}
