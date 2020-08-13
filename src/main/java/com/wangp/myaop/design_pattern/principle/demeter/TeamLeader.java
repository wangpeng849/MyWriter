package com.wangp.myaop.design_pattern.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * classname TeamLeader
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/9 19:05
 **/
public class TeamLeader {

    public List<Course> checkNumberOfCourse() {
        List<Course> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Course());
        }
        return list;
    }
}
