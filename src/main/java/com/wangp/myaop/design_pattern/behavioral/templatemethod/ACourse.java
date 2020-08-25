package com.wangp.myaop.design_pattern.behavioral.templatemethod;

/**
 * <pre>
 * classname ACourse
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/25 22:10
 **/
public abstract class ACourse {

    protected final void makeCourse() {
        makePPT();
        makeVideo();
        if (needWriteArticle()) {
            writeArticle();
        }
        packageCourse();
    }

    final void makePPT() {
        System.out.println("制作PPT");
    }

    final void makeVideo() {
        System.out.println("制作视频");
    }

    final void writeArticle() {
        System.out.println("编写手记");
    }

    //勾子方法
    protected boolean needWriteArticle() {
        return false;
    }

    abstract void packageCourse();

}
