package com.wangp.myaop.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * classname LexicalOrder
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/2/22 10:03
 **/
public class LexicalOrder {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n, i, list);
        }
        return list;
    }

    private void dfs(int n, int i, List<Integer> list) {
        if (i > n) {
            return;
        }
        list.add(i);
        for (int j = 1; j <= 9; j++) {
            dfs(n, i * 10 + j, list);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LexicalOrder().lexicalOrder(13));
    }
}
