package com.kanq.server.sso;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.kanq"})
public class ServerApplication {

    public static void main(String[] args) {
        log.info("sso_server 开始启动.......");
        SpringApplication.run(ServerApplication.class,args);
        log.info("sso_server 启动成功");
    }
}
