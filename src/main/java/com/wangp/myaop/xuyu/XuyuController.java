package com.wangp.myaop.xuyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author wangp
 * @Date 2020/7/15
 * @Version 1.0
 */
@RestController
public class XuyuController {

    @Autowired
    private XuyuMapper xuyuMapper;

    @GetMapping("xuyu")
    public List<Xuyu> query(){
        return xuyuMapper.query();
    }

    @PostMapping("insert")
    @Transactional
    public Integer insert(@RequestBody Xuyu xuyu) throws Exception{
        xuyuMapper.insertXuyu(xuyu.getId(),xuyu.getCompany(),xuyu.getWorkUnit(),xuyu.getControlProject()
                ,xuyu.getXuyu2List());
//         int i = 1/0;
//        xuyuMapper.insertXuyu2(xuyu.getId(),xuyu.getXuyu2List());
        return 1;
    }
}
