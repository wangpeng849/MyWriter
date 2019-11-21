package com.wangp.myaop.xuyu;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FaultRate {
    private int count;
    private String percent;

    public FaultRate() {
    }
}
