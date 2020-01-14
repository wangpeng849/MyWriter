package com.wangp.myaop.repository.impl;

import com.wangp.myaop.entity.MongoUser;
import com.wangp.myaop.repository.UserRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

/**
 * @Author wangp
 * @Date 2020/1/14
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser() {
        MongoUser user = new MongoUser();
        user.setId(849183239l);
        user.setUserName("小明");
        user.setPassWord("123123");
        userRepository.saveUser(user);
    }

    @Test
    public void findUserByUserName() {
        MongoUser user = userRepository.findUserByUserName("小明");
        System.out.println(user);
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUserById() {
    }
}