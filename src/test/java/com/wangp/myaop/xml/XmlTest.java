package com.wangp.myaop.xml;

import com.wangp.myaop.xml.part1.City;
import com.wangp.myaop.xml.part1.CityDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author wangp
 * @Date 2020/6/24
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class XmlTest {

    @Autowired
    private CityDataService cityDataService;

    @Test
    public void xml2Object() throws Exception {
        List<City> cities = cityDataService.listCity();
        System.out.println(cities);
    }
}
