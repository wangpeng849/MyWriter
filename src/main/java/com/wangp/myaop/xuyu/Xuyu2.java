package com.wangp.myaop.xuyu;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Xuyu2 {
    private String inspectionOrder;
    private String causeBy;
    private String remedialAdjustMeasures;
    private LocalDateTime updateTime;
    private String operator;
}