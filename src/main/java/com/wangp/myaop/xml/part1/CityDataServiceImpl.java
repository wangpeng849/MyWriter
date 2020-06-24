package com.wangp.myaop.xml.part1;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/6/24
 * @Version 1.0
 */
@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        Resource resource = new ClassPathResource("cityList.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        StringBuffer bf = new StringBuffer();
        String line = "";
        while((line=br.readLine())!=null){
            bf.append(line);
        }
        br.close();
        CityList cityList = (CityList) XmlBuilder.xmlStr2Object(CityList.class, bf.toString());
        return cityList.getCityLst();
    }
}
