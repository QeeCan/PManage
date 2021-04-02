package com.lee.layui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: QeeLee
 * @Date: 2021/3/27 14:14
 */
@CrossOrigin
@Configuration
public class CrosConfig implements WebMvcConfigurer{

        @Override
        public void addCorsMappings(CorsRegistry registry){
            registry.addMapping("/**").allowedOriginPatterns("*")
                    .allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
                    .allowCredentials(true).maxAge(3600);
        }


}
