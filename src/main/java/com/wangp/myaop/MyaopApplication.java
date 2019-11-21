package com.wangp.myaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MyaopApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyaopApplication.class, args);
    }

}
