package com.book;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序入口
 *
 * @author Zhao Jinyan
 * @date 2019-03-23
 */
@SpringBootApplication(scanBasePackages = "com.book")
@MapperScan("com.book.dao")
public class Application {



    /**
     * 程序入口
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
