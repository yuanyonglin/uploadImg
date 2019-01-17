package com.soyuan.uploadimg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ Author     ：yuanyl.
 * @ Date       ：Created in 17:09 2019/1/15
 * 静态文件放在resources下的配置
 */
@Configuration
public class StaticConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //指定了静态资源文件的位置
        if(!registry.hasMappingForPattern("/static/**")){
            registry.addResourceHandler("/staticFilesUploads/**").addResourceLocations("classpath:/staticFilesUploads/");
        }

        /*//指定了静态资源文件的位置
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/WEB-INF/resources/");*/
    }

}
