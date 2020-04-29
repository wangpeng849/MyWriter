package com.wangp.myaop.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/4/27
 * @Version 1.0
 */
@RestController
public class PageDemo {

    @GetMapping("test_page")
    public PageInfo testPage(@RequestParam("pageNum") Integer pageNum,
                                 @RequestParam("pageSize") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);//后面必须紧跟select查询数据
        List<String> content = Arrays.asList("AAA","BBB","CCC","DDD","EEE","FFF","GGG","HHH","III","JJJ","KKK"
                ,"LLL","MMM","NNN","OOO","PPP","QQQ","RRR","SSS","TTT","UUU","VVV","WWW","XXX","YYY","ZZZ");
        PageInfo info = new PageInfo(content);
        return info;
    }
}
