package com.wangp.myaop.design_pattern.creational.singleton;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/15 11:26
 **/
public class Test {

    public static void main(String[] args)
            throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        LazySingleton lazySingleton = LazySingleton.getInstance();
//        Thread t1 = new Thread(new T());
//        Thread t2 = new Thread(new T());
//        t1.start();
//        t2.start();
//        System.out.println("end");

        //破坏单例模式
//        HungrySingleton instance = HungrySingleton.getInstance();
        //枚举
//        EnumInstance instance = EnumInstance.getInstance();
//        instance.setData(new Object());
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
//        oos.writeObject(instance);
//
//        File file = new File("singleton_file");
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//        EnumInstance newInstance = (EnumInstance) ois.readObject();
//
//        System.out.println(instance.getData());
//        System.out.println(newInstance.getData());
//        System.out.println(instance == newInstance);

        //反射破坏单例模式
//        Class<?> aClass = HungrySingleton.class;

//        Class<StaticInnerClassSingleton> aClass = StaticInnerClassSingleton.class;
//        Constructor<?> constructor = aClass.getDeclaredConstructor();

//        Class<LazySingleton> aClass = LazySingleton.class;
//        Constructor<LazySingleton> constructor = aClass.getDeclaredConstructor();
//        constructor.setAccessible(true);

        //枚举防止反射攻击
//        Class<EnumInstance> aClass = EnumInstance.class;
//        Constructor constructor = aClass.getDeclaredConstructor(String.class, int.class);
//        constructor.setAccessible(true);
//        EnumInstance instance = (EnumInstance) constructor.newInstance("hello", 666);

//        HungrySingleton instance = (HungrySingleton) constructor.newInstance();
//        HungrySingleton newInstance = (HungrySingleton) constructor.newInstance();

//        StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
//        StaticInnerClassSingleton newInstance = (StaticInnerClassSingleton) constructor.newInstance();

//        LazySingleton instance = LazySingleton.getInstance();
//        LazySingleton newInstance = constructor.newInstance();
//
//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);
        
    }
}
