package com.wangp.myaop.datastruct;

import com.github.pagehelper.PageSerializable;
import com.wangp.myaop.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author wangp
 * @Date 2020/5/11
 * @Version 1.0
 */
public class SmallestHip {

    public int[] nums;
    private int pointer;

    public SmallestHip(int capacity) {
        nums = new int[capacity];
        pointer = 1;
    }

    public void siftUp(int newVal) {
        if (pointer < 0 || nums == null || pointer >= nums.length) return;
        nums[pointer] = newVal;
        int i = pointer, p;
        pointer++;

        while (true) {
            if (i == 1) break;
            p = i / 2;
            if (nums[p] <= nums[i]) break;
            swap(p, i);
            i = p;
        }
    }

    public int siftDown() {
        if (pointer < 0 || nums == null || pointer > nums.length) return -1;
        int res = nums[1];
        nums[1] = nums[pointer-1];
        int i = 1,child;
        pointer --;
        while (true){
            child = i*2;
            if  (child >= pointer) break;
            if (child + 1 < pointer) {
                if (nums[child] > nums[child + 1]) child ++;
            }
            if (nums[i] <= nums[child]) break;
            swap(i, child);
            i = child;
        }
        return res;
    }

    private void swap(int i, int p) {
        if (i < 0 || p < 0 || nums == null || i >= nums.length || p >= nums.length) return;
        int tmp = nums[i];
        nums[i] = nums[p];
        nums[p] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        SmallestHip hip = new SmallestHip(10);
        hip.nums = arr;
    }
}
