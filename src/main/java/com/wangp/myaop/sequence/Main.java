package com.wangp.myaop.sequence;

import com.wangp.myaop.sequence.brute_force.BruteForce01;
import com.wangp.myaop.sequence.brute_force.BruteForce02;
import com.wangp.myaop.sequence.brute_force.BruteForce03;
import com.wangp.myaop.sequence.kmp.KMP;
import com.wangp.myaop.union_find.util.Asserts;

/**
 * @Author wangp
 * @Date 2020/6/11
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
//        Asserts.test(BruteForce03.indexOf("Hello World","or") == 7);
//        Asserts.test(BruteForce03.indexOf("Hello World","abc") == -1);
//        Asserts.test(BruteForce03.indexOf("Hello World","H") == 0);
//        Asserts.test(BruteForce02.indexOf("Hello World","ld") == 9);
        Asserts.test(KMP.indexOf("Hello World","or") == 7);
        Asserts.test(KMP.indexOf("Hello World","abc") == -1);
        Asserts.test(KMP.indexOf("Hello World","H") == 0);
        Asserts.test(KMP.indexOf("Hello World","ld") == 9);
    }
}
