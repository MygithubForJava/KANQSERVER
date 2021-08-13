package com.kanq.server.sso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    /**
     * 自定义页面跳转
     * @param registry
     */

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("api").setViewName("redirect:/swagger-ui.html");
        //设置优先级
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }


    /**
     * 自定义资源映射器
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


}
