package com.wangp.myaop.s_jvm.ch05.deencrpt;

public class DemoRun {

    public static void main(String[] args) throws Exception {
        CustomClassLoader demoCustomClassLoader 
        	= new CustomClassLoader("My ClassLoader");
        demoCustomClassLoader.setBasePath("D:\\spring_learn\\MyAop\\bin");
        Class<?> clazz = 
        		demoCustomClassLoader.findClass("com.wangp.myaop.s_jvm.ch05.deencrpt.DemoUser");
        System.out.println(clazz.getClassLoader());
        Object o = clazz.newInstance();
        System.out.println(o);
        //new User(xxx,yyyy,ddd);//
    }
}
