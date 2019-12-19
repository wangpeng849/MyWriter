package com.wangp.myaop.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ThymUser {
    private String name;
    private int age;
    ThymUser friend;
}


