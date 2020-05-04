package com.wangp.myaop.collection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/2/19 14:24
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        /**
         *  arrayList 的删除和新增都用到了
         *  arraycopy(Object src,  int  srcPos,
         *            Object dest, int destPos,
         *            int length);
          */
        int[] srcArr = {0,1,2,3,4,5,6,7,8,9};
        int[] destArr = new int[10];
        System.arraycopy(srcArr,3,destArr,6,4);
        System.out.println(Arrays.toString(destArr)); //[0, 0, 0, 0, 0, 0, 3, 4, 5, 6]
        //删除5的操作
        System.out.println("删除5的操作");
        System.arraycopy(srcArr,6,srcArr,5,srcArr.length-6);
        srcArr[srcArr.length-1] = 0;
        System.out.println(Arrays.toString(srcArr));
        System.out.println("--------------------------------");
        //DEFAULTCAPACITY_EMPTY_ELEMENTDATA  和 EMPTY_ELEMENTDATA  和
        printDefaultCapacityList();
        printEmptyCapacityList();

        // remove將最后一个元素置为null 但是indexOf搜索时未找到
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        System.out.println(arrayList.indexOf(null));
        arrayList.remove("ccc");
        System.out.println(arrayList.indexOf(null));
    }

    public static void printDefaultCapacityList() {
        ArrayList defaultCapacity = new ArrayList();
        System.out.println(
                "default 初始化长度：" + getCapacity(defaultCapacity));

        defaultCapacity.add(1);
        System.out.println(
                "default add 之后 长度：" + getCapacity(defaultCapacity));
    }

    public static void printEmptyCapacityList() {
        ArrayList emptyCapacity = new ArrayList(0);
        System.out.println(
                "empty 初始化长度：" + getCapacity(emptyCapacity));

        emptyCapacity.add(1);
        System.out.println(
                "empty add 之后 长度：" + getCapacity(emptyCapacity));
    }

    public static int getCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            // 获取 elementData 字段
            Field field = arrayListClass.getDeclaredField("elementData");
            // 开启访问权限
            field.setAccessible(true);
            // 把示例传入get，获取实例字段elementData的值
            Object[] objects = (Object[]) field.get(arrayList);
            //返回当前ArrayList实例的容量值
            return objects.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}

