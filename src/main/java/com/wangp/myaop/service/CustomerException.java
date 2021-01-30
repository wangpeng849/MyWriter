package com.wangp.myaop.service;

import lombok.Getter;

/**
 * <pre>
 * classname CustomerException
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/1/30 11:23
 **/
@Getter
public class CustomerException extends RuntimeException {

    private String msg;

    public CustomerException(String msg) {
        super(msg);
    }

}
