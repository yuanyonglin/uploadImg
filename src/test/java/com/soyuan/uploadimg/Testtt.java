package com.soyuan.uploadimg;

import org.junit.Test;
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
public class Testtt {

    public static void main(String[] args) throws Exception{
      /*  String property = System.getProperty("user.dir");
        ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println(property);*/

        /*File path = new File(ResourceUtils.getURL("classpath").getPath());
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if (!path.exists()) path = new File("");
        System.out.println("path________"+path.getAbsolutePath());
        File upload = new File(path.getAbsolutePath(),"src/main/resources/staticFilesUploads/images/");
        String filepath = upload + "\\" + date;
        System.out.println(filepath);*/

    }

    @Test
    public void dotest(HttpServletRequest request){
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String filepath = request.getServletContext().getRealPath("/")+"staticFilesUploads/images/"+date;
        //得到文件命名，并从.开始截取 拼接id成为新的文件名
        //根据路径创建文件夹
        System.out.println(filepath);
        boolean mkdir = new File(filepath).mkdir();
        System.out.println(mkdir);
    }
}
