package com.wangp.myaop.sort_algorithm;

import com.wangp.myaop.util.DecimalsUtil;

import java.text.DecimalFormat;

/**
 * @Author wangp
 * @Date 2020/5/20
 * @Version 1.0
 */
public abstract class Sort implements Comparable<Sort> {
    protected int[] array;
    private int cmpCount;
    private int swapCount;
    private long time;

    private DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public void sort(int[] array) {
        if (array == null || array.length < 2) return;
        this.array = array;
        long start = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - start;
    }

    protected abstract void sort();

    /**
     * @param i1
     * @param i2
     * @return 0 两个相等 1 i1>i2 -1 i1<i2
     */
    protected int cmp(int i1, int i2) {
        cmpCount++;
        return array[i1] - array[i2];
    }

    protected int cmpElement(int v1, int v2) {
        cmpCount++;
        return v1 - v2;
    }

    protected void swap(int i1, int i2) {
        swapCount++;
        int t = array[i1];
        array[i1] = array[i2];
        array[i2] = t;
    }

    @Override
    public String toString() {
        String name = "【" + getClass().getSimpleName() + "】\n";
        String compare = "比较了" + numberString(cmpCount) + "次,";
        String swap = "交换了" + numberString(swapCount) + "次,";
        String t = "耗时" + time + "ms \n";
        return name + compare + swap + t + "---------------------------------------------------\n";
    }

    private String numberString(int number) {
        if (number < 10000) return "" + number;
        if (number < 100000000) return "" + decimalFormat.format(number / 10000) + "万";
        return decimalFormat.format(number / 100000000) + "亿";
    }


    @Override
    public int compareTo(Sort o) {
        int result = (int) (this.time - o.time);
        if (result != 0) return result;
        result = this.cmpCount - o.cmpCount;
        if (result != 0) return result;
        result = this.swapCount - o.swapCount;
        return result;

    }
}
