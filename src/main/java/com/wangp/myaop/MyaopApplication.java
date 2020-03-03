package com.wangp.myaop;

import com.wangp.myaop.zookeeper.kafka.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
public class MyaopApplication {
//    @Autowired
//    private Product product;

//    @PostConstruct
//    public void init() {
//        for (int i = 0; i < 10; i++) {
//            product.send("wangp" + i);
//        }
//    }

    public static void main(String[] args) {
        SpringApplication.run(MyaopApplication.class, args);
    }
}
