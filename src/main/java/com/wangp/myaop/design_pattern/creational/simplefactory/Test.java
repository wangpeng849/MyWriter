package com.wangp.myaop.design_pattern.creational.simplefactory;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/12 19:40
 **/
public class Test {

    public static void main(String[] args) {
        //version1   要导入好多包
//        Video video = new JavaVideo();
//        video.produce();

        //version2  fatory来管理要的对象
//        Video video = new VideoFactory().getVideo("java");
//        video.produce();

        Video video = new VideoFactory().getVideo(JavaVideo.class);
        video.produce();
    }
}
