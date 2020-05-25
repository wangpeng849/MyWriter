package com.wangp.myaop.sort_algorithm.cmp;

import com.wangp.myaop.sort_algorithm.CountingSort;
import com.wangp.myaop.sort_algorithm.CountingSort2;
import com.wangp.myaop.sort_algorithm.RadixSort;

import java.text.DecimalFormat;

/**
 * @Author wangp
 * @Date 2020/5/20
 * @Version 1.0
 */
public abstract class Sort<E extends Comparable<E>> implements Comparable<Sort<E>> {
    protected E [] array;
    private int cmpCount;
    private int swapCount;
    private long time;

    private DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public void sort(E [] array) {
        if (array == null || array.length < 2) return;
        this.array = array;
        long start = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - start;
    }

    protected abstract void sort();

    /**
     * @param i1 索引1
     * @param i2 索引2
     * @return 0 两个相等 1 i1>i2 -1 i1<i2
     */
    protected int cmp(int i1, int i2) {
        cmpCount++;
        return array[i1].compareTo(array[i2]);
    }

    protected int cmp(E v1, E v2) {
        cmpCount++;
        return v1.compareTo(v2);
    }

    protected void swap(int i1, int i2) {
        swapCount++;
        E t = array[i1];
        array[i1] = array[i2];
        array[i2] = t;
    }

    @Override
    public String toString() {
        String name = "【" + getClass().getSimpleName() + "】\n";
        String compare = "比较了" + numberString(cmpCount) + "次,";
        String swap = "交换了" + numberString(swapCount) + "次,";
        String t = "耗时" + time + "ms,\n";
        String stableStr = "稳定性：" + isStable() + ","; //稳定性会调用swap 和 cmp 以及时间方法 此处放后面则不会影响次数
        return name + compare + swap + stableStr + t + "---------------------------------------------------\n";
    }

    private String numberString(int number) {
        if (number < 10000) return "" + number;
        if (number < 100000000) return "" + decimalFormat.format(number / 10000) + "万";
        return decimalFormat.format(number / 100000000) + "亿";
    }


    @Override
    public int compareTo(Sort<E> o) {
        int result = (int) (this.time - o.time);
        if (result != 0) return result;
        result = this.cmpCount - o.cmpCount;
        if (result != 0) return result;
        result = this.swapCount - o.swapCount;
        return result;

    }

    private boolean isStable(){
        if(this instanceof ShellSort) return false;
        if(this instanceof CountingSort) return false;
        if(this instanceof CountingSort2) return true;
        if(this instanceof RadixSort) return true;
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(i*10,10);
        }
        sort((E[]) students);
        for (int i = 1; i < students.length; i++) {
            if(students[i].getScore() != students[i -1 ].getScore() + 10) return false;
        }
        return true;
    }
}
