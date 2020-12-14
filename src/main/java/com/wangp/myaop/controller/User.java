package com.wangp.myaop.controller;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <pre>
 * classname User
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/12/11 16:30
 **/
@Data
@TableName("tb_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String phone;
    private String sex;
}
