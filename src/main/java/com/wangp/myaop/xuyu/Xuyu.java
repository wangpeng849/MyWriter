package com.wangp.myaop.xuyu;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/7/15
 * @Version 1.0
 */
@Data
public class Xuyu {
    private Integer id;
    private String company;
    private String workUnit;
    private String controlProject;
    private List<Xuyu2> xuyu2List;

}
