package com.gs.qiuzhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ImportResource(locations = {"classpath:mykaptcha.xml"}) //配置bean注入类
public class QiuzhiApplication extends WebMvcConfigurerAdapter {

    //配置url匹配规则 拦截带后缀的和不带后缀的
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(true).setUseTrailingSlashMatch(true);
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/src/main/webapp/**").addResourceLocations("classpath:/webapp/");
//        super.addResourceHandlers(registry);
//    }


    public static void main(String[] args) {
        SpringApplication.run(QiuzhiApplication.class, args);
    }
}
