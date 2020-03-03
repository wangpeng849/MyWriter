package com.wangp.myaop.redis;

import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/2/27 8:48
 */
public class RedisDemo {

    public static void saveAllRedis(final String redisIp, final int redisPort, final String appCode) {
        Jedis jedis = new Jedis(redisIp, redisPort);
        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        if (iterator.hasNext()) {
            String str = iterator.next();
            saveRedisObject(jedis, str, redisIp, redisPort + "", appCode);
        }
    }

    private static void saveRedisObject(final Jedis redis, final String redisKey, final String macIp, final String port, final String appCode) {
        String redisType = redis.type(redisKey);
        RedisTable redisTable = new RedisTable();
        redisTable.setAppCode(appCode);
        redisTable.setCreateTime(new Date());
        redisTable.setMacIp(macIp);
        redisTable.setPort(port);
        redisTable.setRedisKey(redisKey);
        redisTable.setRedisType(redisType);
        redisTable.setRemark("");
        redisTable.setUpdateTime(new Date());
        //set集合
        if ("set".equalsIgnoreCase(redisType)) {
            Set<String> setStrings = redis.smembers(redisKey);//获取key的所有set集合
            if (null != setStrings && !setStrings.isEmpty()) {
                Iterator<String> setIterator = setStrings.iterator();
                while (setIterator.hasNext()) {
                    Object obj1 = setIterator.next();
                    redisTable.setRedisValue(obj1 + "");
                    printRedis(redisTable);//保存每一个set记录
                }
            }
            //hash集合
        } else if ("hash".equalsIgnoreCase(redisType)) {
            Set<String> hashSets = redis.hkeys(redisKey);
            if (null != hashSets && !hashSets.isEmpty()) {
                Iterator<String> setIterator = hashSets.iterator();
                while (setIterator.hasNext()) {
                    String objectName = setIterator.next() + "";
                    redisTable.setObjectName(objectName);
                    redisTable.setRedisValue(redis.hget(redisKey, objectName));
                    printRedis(redisTable);//保存每一个set记录
                }
            }
            //list集合
        } else if ("list".equalsIgnoreCase(redisType)) {
            Long listLen = redis.llen(redisKey);
            for (Long i = 0L; i < listLen; i++) {
                redisTable.setRedisValue(redis.lindex(redisKey, i));
                printRedis(redisTable);
            }
            //sortedset集合
        } else if ("sortedset".equalsIgnoreCase(redisType)) {
            // Long redisLenth = redis.zcard(redisKey);
            Set<String> sortedsets = redis.zrange(redisKey, 0, -1);
            if (null != sortedsets && !sortedsets.isEmpty()) {
                Iterator<String> setIterator = sortedsets.iterator();
                while (setIterator.hasNext()) {
                    String sortedMember = setIterator.next() + "";
                    redisTable.setRedisValue(sortedMember);
                    redisTable.setScore("" + redis.zscore(redisKey, sortedMember));
                    //保存每一个sortedset记录
                    printRedis(redisTable);
                }
            }
            //string集合
        } else if ("string".equalsIgnoreCase(redisType)) {
            redisTable.setRedisValue(redis.get(redisKey));
            //保存记录
            printRedis(redisTable);
        } else {
            System.out.println("UnknowRedisType-----redisType: " + redisType + "objValue: " + redis.get(redisKey));
        }
    }

    //打印输出
    public static void printRedis(RedisTable redisTable) {
        System.out.println("redisType:" + redisTable.getRedisType() + " redisKey:" + redisTable.getRedisKey() + " ObjectName:" + redisTable.getObjectName()
                + " redisValue:" + redisTable.getRedisValue() + " redisScore:" + redisTable.getScore());
    }

    public static void main(String[] args) {
        String redisIp = "127.0.0.1";//redis的IP地址
        int redisPort = 6379;//redis的端口号
        String appCode = "";//根据不同的应用区分的appcode
        saveAllRedis(redisIp,redisPort,appCode);
    }
}
