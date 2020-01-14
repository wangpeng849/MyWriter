package com.wangp.myaop.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author wangp
 * @Date 2020/1/14
 * @Version 1.0
 */
@Data
public class MongoUser implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
    private Long id;
    private String userName;
    private String passWord;
}
