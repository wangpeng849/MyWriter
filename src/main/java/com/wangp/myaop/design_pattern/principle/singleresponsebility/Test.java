package com.wangp.myaop.design_pattern.principle.singleresponsebility;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/9 18:28
 **/
public class Test {

    public static void main(String[] args) {
        
        FlyBird flyBird = new FlyBird();
        flyBird.move("大雁");

        WalkBird walkBird = new WalkBird();
        walkBird.move("鸵鸟");
    }
}
