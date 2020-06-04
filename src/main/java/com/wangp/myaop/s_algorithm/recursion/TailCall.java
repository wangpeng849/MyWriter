package com.wangp.myaop.s_algorithm.recursion;

/**
 * @Author wangp
 * @Date 2020/6/3
 * @Version 1.0
 * <p>
 * 尾调用：一个函数的最后一个动作是调用函数
 * 如果最后一个动作是调用自身，成为尾递归
 */
public class TailCall {
    void test1() {  //此为尾调用
        int a = 10;
        int b = a + 10;
        test2(b);
    }

    void test2(int b) { //10个字节
        int x1 = 20;
        int x2 = 30;
        //尾调用优化就是 将test1中 a = 20 b = 30
    }

    int function(int n) { //这种不是尾调用 因为最后是乘法
        int a = 1;
        return n * function(n - 1);
    }

    /**
     * 阶乘
     * 空间复杂度 O(n)
     */
    int factorial(int n) {
        if (n <= 1) return n;
        return n * factorial(n - 1);
    }

    int factorial_tailCall(int n) {
        return factorial_tailCall(n, 1);
    }

    int factorial_tailCall(int n, int result) {
        if (n <= 1) return result;
        return factorial_tailCall(n - 1, result * n);
    }

    int fib(int n){
        if(n<=2) return 1;
        return fib(n-1)+fib(n-2);
    }

    int fib_tailCall(int n){
        return fib_tailCall(n,1,1);
    }

    int fib_tailCall(int n,int first,int second){
        if(n<=1) return first;
        return fib_tailCall(n-1,second,first+second);
    }

    public static void main(String[] args) {
        TailCall tailCall = new TailCall();
        System.out.println(tailCall.factorial(3));
        System.out.println(tailCall.factorial_tailCall(3));

        System.out.println(tailCall.fib(10));
        System.out.println(tailCall.fib_tailCall(10));
    }
}
