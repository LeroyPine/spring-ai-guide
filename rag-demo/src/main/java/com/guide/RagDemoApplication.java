package com.guide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring AI 指南项目主启动类
 * 用于启动 Spring Boot 应用程序
 * 
 * @author guide
 */
@SpringBootApplication
class RagDemoApplication {

    /**
     * 程序入口点
     * 启动 Spring Boot 应用程序
     * 
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(RagDemoApplication.class, args);
    }

}
