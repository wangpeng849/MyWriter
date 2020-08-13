package com.wangp.myaop.design_pattern.principle.demeter;

import java.util.List;

/**
 * <pre>
 * classname Boss
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/9 19:05
 **/
public class Boss {

    public List<Course> commandCheckNumber(TeamLeader leader) {
        return leader.checkNumberOfCourse();
    }
}
