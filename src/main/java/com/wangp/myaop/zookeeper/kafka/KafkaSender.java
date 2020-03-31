package com.wangp.myaop.zookeeper.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/2/25 10:58
 */
@Component
@Slf4j
public class KafkaSender {

//    @Autowired
//    private KafkaTemplate kafkaTemplate;

//    @KafkaListener(topics = {"hello"})
//    public void sendTest(){
//        kafkaTemplate.send("hello","hello,kafka" + LocalTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
//
//    }
}
