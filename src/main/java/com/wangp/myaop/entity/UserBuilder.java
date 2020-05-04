package com.wangp.myaop.entity;

/**
 * @Author wangp
 * @Date 2020/4/30
 * @Version 1.0
 */
public class UserBuilder {

    private UserBuilder(Builder builder) {
        name = builder.name;
        age = builder.age;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private int age;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder build() {
            return new UserBuilder(this);
        }
    }

}
