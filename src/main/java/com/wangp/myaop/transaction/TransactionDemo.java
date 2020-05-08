package com.wangp.myaop.transaction;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangp
 * @Date 2020/5/4
 * @Version 1.0
 */
@RestController
public class TransactionDemo {

    @Mapper
    interface TransactionMapper{
        @Insert("insert into score (id,name,score,status) value (6,'高一',55,1)")
        int insertOneData();
        @Delete("delete from score where id = 6")
        int deleteOneData();
    }

    @Autowired
    TransactionMapper transactionMapper;

    @GetMapping("transaction")
    public String transactionBehavior(){
        insert();
        delete();
        return "OK";
    }

    @Transactional
    public void insert(){
        int i = transactionMapper.insertOneData();
    }
    @Transactional()
    public  void delete(){
        int error = 1/0;
        int i = transactionMapper.deleteOneData();
    }
}
