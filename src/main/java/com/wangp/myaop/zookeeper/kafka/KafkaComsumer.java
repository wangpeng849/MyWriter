package com.wangp.myaop.zookeeper.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/2/25 10:58
 */
@Component
@Slf4j
public class KafkaComsumer {

//    @KafkaListener(topics = {"hello"})
//    public void comsumer(String message){
//        log.info("c1 消费了 hello topic message:{}",message);
//    }
}
