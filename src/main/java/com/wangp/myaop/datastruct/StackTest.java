package com.wangp.myaop.datastruct;

import org.thymeleaf.model.IStandaloneElementTag;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author wangp
 * @Date 2020/4/23
 * @Version 1.0
 */
public class StackTest<T> {


    private List<T> stack;

    public StackTest(){
        stack = new ArrayList<>();
     }

    public T peek(){
        if(stack.size() == 0){
            return null;
        }
        return stack.get(stack.size()-1);
    }

    public T pop(){
        if(stack.size() == 0){
            return null;
        }
        T t = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return t;
    }

    public void push(T t){
        stack.add(0,t);
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add(0,"ccc");
        System.out.println(list);

    }
}
