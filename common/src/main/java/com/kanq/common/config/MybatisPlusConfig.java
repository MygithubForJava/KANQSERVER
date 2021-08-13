package com.kanq.common.config;



import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.kanq.*.dao.*")
public class MybatisPlusConfig {

    /**
     * 重写mybatisplus分页方法。分页设置
     * @return
     */

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor=new PaginationInterceptor();
        paginationInterceptor.setLimit(1000L);
        return paginationInterceptor;
    }
}
