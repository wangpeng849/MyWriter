package com.wangp.myaop.s_jvm.ch05.dispatch;


/**
 *
 *类说明：解析
 */
public class StaticDispatch{
	
	static abstract class Human{}
	static class Man extends Human{	}
	static class Woman extends Human{}
	
	public void sayHello(Human guy){
		System.out.println("hello,guy！");//1
	}
	public void sayHello(Man guy){
		System.out.println("hello,gentleman！");//2
	}
	public void sayHello(Woman guy){
		System.out.println("hello,lady！");//3
	}
	
	public static void main(String[]args){
		//解析：类的静态方法，构造方法，私有方法    在编译期间就可以知道
		//静态分配（方法的重载）
		//静态类型      实际类型       方法重载由静态类型决定
		// |				|
		//\|/			   \|/
		Human h1 =  new Man();
		Human h2 =  new Woman();
		
		StaticDispatch sr = new StaticDispatch();
		sr.sayHello(h1);
		sr.sayHello(h2);
		//hello,guy！
		//hello,guy！
		
	}
}
