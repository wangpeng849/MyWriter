package com.wangp.myaop.service;

import com.wangp.myaop.controller.User;
import com.wangp.myaop.controller.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * classname RollBackService
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/1/30 11:16
 **/
@Service
public class RollBackService {

    private final UserMapper userMapper;

    @Autowired
    public RollBackService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional(timeout = 1, rollbackFor = Exception.class)
    public void rollback() {
        // rollback
        User user = new User();
        user.setAge(30);
        user.setPhone("1827999");
        user.setName("goodbye");
        user.setSex("1");
        userMapper.addUser(user);
        throw new CustomerException("rollback..");
    }

    @Transactional(timeout = 1, noRollbackFor = CustomerException.class, rollbackFor = Exception.class)
    public void rollback2() {
        // no roll back
        User user = new User();
        user.setAge(30);
        user.setPhone("1827999");
        user.setName("goodbye");
        user.setSex("1");
        userMapper.addUser(user);
        throw new CustomerException("rollback..");
    }

    @Transactional(timeout = 1, noRollbackFor = CustomerException.class, rollbackFor = Exception.class)
    public void rollback3() {
        // roll back
        User user = new User();
        user.setAge(30);
        user.setPhone("1827999");
        user.setName("goodbye");
        user.setSex("1");
        userMapper.addUser(user);
        throw new RuntimeException("rollback..");
    }
}
