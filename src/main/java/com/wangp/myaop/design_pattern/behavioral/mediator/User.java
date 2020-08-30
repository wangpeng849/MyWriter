package com.wangp.myaop.design_pattern.behavioral.mediator;

/**
 * <pre>
 * classname User
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 11:24
 **/
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        StudyGroup.showMessage(this, message);
    }
}
