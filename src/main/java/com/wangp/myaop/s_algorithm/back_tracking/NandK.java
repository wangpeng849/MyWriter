package com.wangp.myaop.s_algorithm.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * classname NandK
 * description n 个数和为 K
 * </pre>
 *
 * @author wangpeng
 * @date 2020/12/31 15:15
 **/
public class NandK {

    public static void main(String[] args) {
        System.out.println(new NandK().nandk(3, 10));
    }

    public List<List<Integer>> nandk(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> tempList, int k, int n, int index) {
        if (tempList.size() == k && listSum(tempList) == n) {
            res.add(new ArrayList<>(tempList));
        }
        for (int i = index; i < 10; i++) {
            tempList.add(i);
            dfs(res, tempList, k, n, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    private int listSum(ArrayList<Integer> tempList) {
        int sum = 0;
        for (int i = 0; i < tempList.size(); i++) {
            sum += tempList.get(i);
        }
        return sum;
    }
}
