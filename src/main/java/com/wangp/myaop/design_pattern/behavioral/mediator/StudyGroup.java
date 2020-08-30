package com.wangp.myaop.design_pattern.behavioral.mediator;

import java.util.Date;

/**
 * <pre>
 * classname StudyGroup
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 11:23
 **/
public class StudyGroup {

    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + "[" + user.getName() + "]" + message);
    }
}
