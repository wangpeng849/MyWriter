package com.wangp.myaop.sync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * <pre>
 * classname CompletableFutureTest
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/20 17:10
 **/
@EnableAsync
public class CompletableFutureTest {

    @Test
    public void completableFutureTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 3;
        }, executorService);
        completableFuture.thenAccept(System.out::println);
    }


    @Test
    public void stringTest() {
        String nullStr = (String) null;
        System.out.println(StringUtils.isEmpty("null"));
    }
}
