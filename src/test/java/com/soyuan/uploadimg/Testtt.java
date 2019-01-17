package com.soyuan.uploadimg;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.io.IOUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author     ：yuanyl.
 * @ Date       ：Created in 16:02 2019/1/11
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class Testtt {
/*

    public static void main(String[] args) throws Exception{
      */
/*  String property = System.getProperty("user.dir");
        ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println(property);*//*


        */
/*File path = new File(ResourceUtils.getURL("classpath").getPath());
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if (!path.exists()) path = new File("");
        System.out.println("path________"+path.getAbsolutePath());
        File upload = new File(path.getAbsolutePath(),"src/main/resources/staticFilesUploads/images/");
        String filepath = upload + "\\" + date;
        System.out.println(filepath);*//*

 */
/*       File file = ResourceUtils.getFile("classpath:templates");
        String filepath = file.toString();
        if (filepath == null) {
            //因为new File(null)会空指针异常,所以要判断下
            return;
        }
        File[] testFile = new File(filepath).listFiles();
        if (testFile == null) {
            return;
        }
        for (File files : testFile) {
            if (files.isFile()) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                System.out.println("-------this is a directory, and its files are as follows:-------");

                testLoopOutAllFileName(file.getPath())
            } else {
                System.out.println("文件读入有误！");
            }
        }*//*


    }
*/


    /**
     * 递归读取文件夹下的 所有文件
     *
     * @param filepath 文件名或目录名
     */
    @Test
    public void testLoopOutAllFileName() throws Exception{
        File files = ResourceUtils.getFile("classpath:templates");
        String filepath = files.toString();
        if (filepath == null) {
            //因为new File(null)会空指针异常,所以要判断下
            return;
        }
        File[] testFile = new File(filepath).listFiles();
        if (testFile == null) {
            return;
        }
        for (File file : testFile) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                System.out.println("-------this is a directory, and its files are as follows:-------");
                testLoopOutAllFileName();
            } else {
                System.out.println("文件读入有误！");
            }
        }
    }

}
