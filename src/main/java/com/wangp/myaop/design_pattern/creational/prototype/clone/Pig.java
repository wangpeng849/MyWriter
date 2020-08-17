package com.wangp.myaop.design_pattern.creational.prototype.clone;

import java.util.Date;
import lombok.AllArgsConstructor;

/**
 * <pre>
 * classname Pig
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/17 19:42
 **/
@AllArgsConstructor
public class Pig implements Cloneable {

    private String name;
    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Pig pig = (Pig) super.clone();
        //深克隆代码
        pig.birthday = (Date) pig.getBirthday().clone();
        return pig;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}' + super.toString();
    }
}
