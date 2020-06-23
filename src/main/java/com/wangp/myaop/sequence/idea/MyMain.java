package com.wangp.myaop.sequence.idea;

import java.util.Arrays;

/**
 * @Author wangp
 * @Date 2020/6/23
 * @Version 1.0
 */
public class MyMain {
    public static String reverse(String str) {
        char[] value = str.toCharArray();
        int n = str.length() - 1;
        for (int j = (n - 1) >> 1; j >= 0; j--) {
            int k = n - j;
            System.out.print("j=" + j);
            System.out.println(",k=" + k);
            char cj = value[j];
            char ck = value[k];
            value[j] = ck;
            value[k] = cj;
        }
        return new String(value);
    }


    public static void main(String[] args) {
//        System.out.println(reverse("123456"));
        int[] source = {1,2,3};
        int[] dest = {4,5,6};
        //[4, 2, 3]
        System.arraycopy(source,1,dest,1,2);
        System.out.println(Arrays.toString(dest));

        //F
        //S
        F f = new S();
        //F
        //S
        S s = new S();
    }
}

abstract class F{
    public F(){
        System.out.println("F");
    }
}
class S extends F{
    public S(){
        System.out.println("S");
    }
}
