package com.wangp.myaop.redis;

import lombok.Data;

import java.util.Date;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/2/27 8:57
 */
@Data
public class RedisTable {
    private String appCode;
    private Date createTime;
    private String objectName;
    private String redisValue;
    private String score;
    private Date updateTime;
    private String remark;
    private String redisType;
    private String port;
    private String macIp;
    private String redisKey;
}
