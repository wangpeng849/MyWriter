package com.wangp.myaop.coding;

public class ParseInteger {

    /**
     * 由于连续整数相加为一个等差数列 公差为 1
     * S = (a1 + an)*n/2
     * 2S = 2n*a1 + n(n-1)
     *

     * @param num
     */
    public static void parseInteger(int num){
        boolean flag = true;
        // 由于连续整数下 则至少为两个相差1的数字相加
        // 所以实际上不会超过 num/2 + 1
        for(int i=1;i<num/2 + 1 ;i++){
            for(int j=1;j<num/2 +1;j++){
                //带入公式
                if(2 *num == 2*j*i + j*(j-1)){
                    flag = false;
                    for (int k = 0; k < j; k++) {
                        System.out.print(i+k + " ");
                    }
                    System.out.println();
                }
            }

        }
        if(flag){
            System.out.println("NONE");
        }
    }

    //测试
    public static void main(String[] args) {
        parseInteger(9999);
    }
}
