package com.dukl.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by adu on 2019/5/19.
 */
@SpringBootApplication
@EnableScheduling // 这里，启用定时任务
@ComponentScan("com.dukl.wechat.web")
public class WeChatToolMpApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(WeChatToolMpApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WeChatToolMpApplication.class);
    }
}
