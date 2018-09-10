package com.gs.qiuzhi;

import com.gs.qiuzhi.interceptor.AdminInterceptor;
import com.gs.qiuzhi.interceptor.UserInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootApplication
@ImportResource(locations = {"classpath:mykaptcha.xml"}) //配置bean注入类
@EnableCaching
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
//     @Override
//     public void addResourceHandlers(ResourceHandlerRegistry registry) {
//         registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
//     }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns(new String[]{"/adminIndex.do","/userManagement.do","/adManagement.do",
        "/kwManagement.do","/addKW.do","/admin/**"});

        registry.addInterceptor(new UserInterceptor()).addPathPatterns(new String[]{"/klManagement.do"});
    }

    public static void main(String[] args) {
        SpringApplication.run(QiuzhiApplication.class, args);
    }
}
