package com.wangp.myaop.controller;

import com.wangp.myaop.service.RollBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * classname RollBackController
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/1/30 11:15
 **/
@RestController
public class RollBackController {

    @Autowired
    RollBackService rollBackService;

    @GetMapping("rollback")
    public void rollback() {
        rollBackService.rollback();
    }

    @GetMapping("rollback2")
    public void rollback2() {
        rollBackService.rollback2();
    }

    @GetMapping("rollback3")
    public void rollback3() {
        rollBackService.rollback3();
    }
}
