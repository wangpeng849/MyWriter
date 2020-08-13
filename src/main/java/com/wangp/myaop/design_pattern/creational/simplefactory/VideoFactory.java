package com.wangp.myaop.design_pattern.creational.simplefactory;

/**
 * <pre>
 * classname VideoFactory
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/12 19:40
 **/
public class VideoFactory {

    //v1
//    public Video getVideo(String type) {
//        if ("java".equals(type)) {
//            return new JavaVideo();
//        } else if ("python".equals(type)) {
//            return new PythonVideo();
//        } else {
//            return null;
//        }
//    }

    public Video getVideo(Class c) {
        Video video = null;
        try {
//            video = (Video) Class.forName(c.getName()).newInstance();
            video = (Video) c.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return video;
    }
}
