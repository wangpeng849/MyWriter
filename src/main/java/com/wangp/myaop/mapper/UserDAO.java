package com.wangp.myaop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangp.myaop.controller.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <pre>
 * classname UserDAO
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/12/11 16:29
 **/
@Mapper
public interface UserDAO extends BaseMapper<User> {
    
}
