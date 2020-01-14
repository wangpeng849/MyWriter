package com.wangp.myaop.repository;

import com.wangp.myaop.entity.MongoUser;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author wangp
 * @Date 2020/1/14
 * @Version 1.0
 */
public interface UserRepository {
     void saveUser(MongoUser user);
     MongoUser findUserByUserName(String username);
     long updateUser(MongoUser user);
     void deleteUserById(long id);
}
