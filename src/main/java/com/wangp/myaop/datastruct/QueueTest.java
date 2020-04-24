package com.wangp.myaop.datastruct;

import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * @Author wangp
 * @Date 2020/4/23
 * @Version 1.0
 */
public class QueueTest {
    /**
     *     add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
     * 　　remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
     * 　　element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
     * 　　offer       添加一个元素并返回true       如果队列已满，则返回false
     * 　　poll         移除并返问队列头部的元素    如果队列为空，则返回null
     * 　　peek       返回队列头部的元素             如果队列为空，则返回null
     * 　　put         添加一个元素                      如果队列满，则阻塞
     * 　　take        移除并返回队列头部的元素     如果队列为空，则阻塞
     */
    public static void main(String[] args) {
        Assert.hasText("   ","map不能为空");
        System.out.println("hello world");
    }
}
