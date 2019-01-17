package com.soyuan.uploadimg;

import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author     ：yuanyl.
 * @ Date       ：Created in 11:54 2019/1/17
 */
public class sssss {
    public static void main(String[] args) throws Exception{
        String property = System.getProperty("user.dir");
        System.out.println(property);
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String path= property+"/src/main/resources/staticFilesUploads/images/"+date;
        boolean mkdirs = new File(path).mkdirs();
        System.out.println(mkdirs);
    }
}
