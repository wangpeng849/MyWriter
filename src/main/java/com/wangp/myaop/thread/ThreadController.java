package com.wangp.myaop.thread;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @Author farling
 * @Date 2019/12/10
 */
@RestController
public class ThreadController {
    @Autowired
    TestMapper testMapper;

    @Autowired
    ExecutorService executorService;

    @Bean(name="executorService")
    public ExecutorService getExecutorService(){
        return newFixedThreadPool(2);
    }
//    ExecutorService executorService = newFixedThreadPool(2);


    @GetMapping("/test1")
    public String test1() {
        long s = System.currentTimeMillis();

        List<TestVo> testVos = testMapper.test11();
        List<TestDo> testDos = testMapper.test12();

        return "Ok,spend time -> " + (System.currentTimeMillis() - s) + "总数据为：" + (testVos.size() + testDos.size());
    }

    @GetMapping("/test2")
    public String test2() throws InterruptedException {
        long s = System.currentTimeMillis();


        MyRunnable r1 = new MyRunnable();
        MyRunnable2 r2 = new MyRunnable2();

//        Runnable run1 = () -> {
//            List<TestVo> testVos1 = testMapper.test11();
//            System.out.println(testVos1.size());
//        };
//        Runnable run2 = () -> {
//            List<TestDo> testDos1 = testMapper.test12();
//            System.out.println(testDos1.size());
//        };
//        executorService.submit(run1);
//        executorService.submit(run2);
        executorService.execute(r1);
        executorService.execute(r2);
        while(r1.getTestVos()==null || r2.getTestDos()==null || r1.getTestVos().size() == 0 || r2.getTestDos().size() == 0){

        }
        return "Ok,spend time -> " + (System.currentTimeMillis() - s) + "总数据为：" + (r1.getTestVos().size() + r2.getTestDos().size());
    }

    @Data
    class MyRunnable implements Runnable {
        List<TestVo> testVos = new ArrayList<>();

        public MyRunnable() {
        }

        @Override
        public void run() {
            long s = System.currentTimeMillis();
          setTestVos(testMapper.test11());
            System.out.println("vo 花费时间" + (System.currentTimeMillis() - s));
        }
    }

    @Data
    class MyRunnable2 implements Runnable {
        List<TestDo> testDos = new ArrayList<>();
        public MyRunnable2( ) {
        }

        @Override
        public void run() {
            long s = System.currentTimeMillis();
            testDos=testMapper.test12();
            System.out.println("do 花费时间" + (System.currentTimeMillis() - s));
        }
    }


    @GetMapping("/insert")
    public String insert(){
        while(true){
            testMapper.insert();
        }
//        return "OK";
    }
}
