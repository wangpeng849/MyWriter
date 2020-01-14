package com.wangp.myaop.repository.impl;

import com.mongodb.Mongo;
import com.mongodb.client.result.UpdateResult;
import com.wangp.myaop.entity.MongoUser;
import com.wangp.myaop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @Author wangp
 * @Date 2020/1/14
 * @Version 1.0
 */
@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(MongoUser user){
        mongoTemplate.save(user);
    }

    @Override
    public MongoUser findUserByUserName(String username){
        Query query = new Query(Criteria.where("userName").is(username));
        MongoUser user = mongoTemplate.findOne(query, MongoUser.class);
        return user;
    }

    @Override
    public long updateUser(MongoUser user){
        Query query=new Query(Criteria.where("id").is(user.getId()));
        Update update= new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
        //更新查询返回结果集的第一条
        UpdateResult result =mongoTemplate.updateFirst(query,update,MongoUser.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
        if(result!=null)
            return result.getMatchedCount();
        else
            return 0;
    }

    @Override
    public void deleteUserById(long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,MongoUser.class);
    }
}
