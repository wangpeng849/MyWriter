package com.wangp.myaop.thread;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @Author farling
 * @Date 2019/12/10
 */
@RestController
public class ThreadController {
    @Autowired
    NewTestMapper testMapper;

    @Autowired
    ExecutorService executorService;

    @Bean(name = "executorService")
    public ExecutorService getExecutorService() {
        return new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(100));
    }
//    ExecutorService executorService = newFixedThreadPool(2);


    @GetMapping("/test1")
    public String test1() {
        long s = System.currentTimeMillis();

        List<TestVo> testVos = testMapper.test11();
        List<TestDo> testDos = testMapper.test12();
        List<TestPo> testPos = testMapper.test13();
        List<TestJo> testJos = testMapper.test14();
        List<TestKo> testKos = testMapper.test15();
        List<TestVo> testVos1 = testMapper.test11();
        List<TestDo> testDos1 = testMapper.test12();
        List<TestPo> testPos1 = testMapper.test13();
        List<TestJo> testJos1 = testMapper.test14();
        List<TestKo> testKos1 = testMapper.test15();
        return "Ok,spend time -> " + (System.currentTimeMillis() - s) + "总数据为："
                + (testVos.size() + testDos.size() + testPos.size() + testKos.size() + testJos.size()
                + testVos.size() + testDos.size() + testPos.size() + testKos.size() + testJos.size());
    }

    @GetMapping("/test2")
    public String test2() throws InterruptedException {
        long s = System.currentTimeMillis();


        MyRunnable r1 = new MyRunnable();
        MyRunnable2 r2 = new MyRunnable2();
        MyRunnable3 r3 = new MyRunnable3();
        MyRunnable4 r4 = new MyRunnable4();
        MyRunnable5 r5 = new MyRunnable5();
        MyRunnable r11 = new MyRunnable();
        MyRunnable2 r22 = new MyRunnable2();
        MyRunnable3 r33 = new MyRunnable3();
        MyRunnable4 r44 = new MyRunnable4();
        MyRunnable5 r55 = new MyRunnable5();

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
        executorService.execute(r3);
        executorService.execute(r4);
        executorService.execute(r5);
        executorService.execute(r11);
        executorService.execute(r22);
        executorService.execute(r33);
        executorService.execute(r44);
        executorService.execute(r55);
        while (r1.getTestVos().size() == 0 || r2.getTestDos().size() == 0 ||
                r3.getTestDos().size() == 0 || r4.getTestDos().size() == 0 || r5.getTestDos().size() == 0 ||
                r11.getTestVos().size() == 0 || r22.getTestDos().size() == 0 ||
                r33.getTestDos().size() == 0 || r44.getTestDos().size() == 0 || r55.getTestDos().size() == 0) {

        }
        return "Ok,spend time -> " + (System.currentTimeMillis() - s) + "总数据为："
                + (r1.getTestVos().size() + r2.getTestDos().size() + r3.getTestDos().size() + r4.getTestDos().size() + r5.getTestDos().size()
                + r1.getTestVos().size() + r2.getTestDos().size() + r3.getTestDos().size() + r4.getTestDos().size() + r5.getTestDos().size());
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

        public MyRunnable2() {
        }

        @Override
        public void run() {
            long s = System.currentTimeMillis();
            testDos = testMapper.test12();
            System.out.println("do 花费时间" + (System.currentTimeMillis() - s));
        }
    }

    @Data
    class MyRunnable3 implements Runnable {
        List<TestPo> testDos = new ArrayList<>();

        @Override
        public void run() {
            long s = System.currentTimeMillis();
            testDos = testMapper.test13();
            System.out.println("po 花费时间" + (System.currentTimeMillis() - s));
        }
    }

    @Data
    class MyRunnable4 implements Runnable {
        List<TestJo> testDos = new ArrayList<>();

        @Override
        public void run() {
            long s = System.currentTimeMillis();
            testDos = testMapper.test14();
            System.out.println("jo 花费时间" + (System.currentTimeMillis() - s));
        }
    }

    @Data
    class MyRunnable5 implements Runnable {
        List<TestKo> testDos = new ArrayList<>();

        @Override
        public void run() {
            long s = System.currentTimeMillis();
            testDos = testMapper.test15();
            System.out.println("ko 花费时间" + (System.currentTimeMillis() - s));
        }
    }


    @GetMapping("/insert")
    public String insert() {
        while (true) {
            testMapper.insert();
        }
//        return "OK";
    }
}
