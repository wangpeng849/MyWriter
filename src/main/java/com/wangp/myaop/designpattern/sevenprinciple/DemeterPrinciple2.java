package com.wangp.myaop.designpattern.sevenprinciple;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 10:57
 *
 * 迪米特法则
 * 一个对象对其他类保持最少的了解
 */
public class DemeterPrinciple2 {
    public static void main(String[] args) {
        new SchoolManager().printAllEmployee(new CollegeManager());
    }
}

@Data
class NewEmployee{
    private String id;
}

@Data
class NewCollegeEmployee{
    private String id;
}

class NewCollegeManager{
    public List< NewCollegeEmployee> getAllEmployee(){
        List<NewCollegeEmployee> list = new ArrayList<>();
        for(int i = 0;i<10;i++){
            NewCollegeEmployee emp = new  NewCollegeEmployee();
            emp.setId("学院员工id:"+i);
            list.add(emp);
        }
        return list;
    }
    public void printAllEmployee(){
        List< NewCollegeEmployee> list1 = getAllEmployee();
        System.out.println("分公司员工");
        for ( NewCollegeEmployee collegeEmployee : list1) {
            System.out.println(collegeEmployee.getId());
        }
    }
}

class NewSchoolManager{
    public List< NewEmployee> getAllEmployee(){
        List< NewEmployee> list = new ArrayList<>();
        for(int i = 0;i<5;i++){
            NewEmployee emp = new  NewEmployee();
            emp.setId("学校总部员工id:"+i);
            list.add(emp);
        }
        return list;
    }

    void printAllEmployee( NewCollegeManager sub){

        //1. 此处的CollegeEmployee不是 SchoolManager的直接朋友
        //2. CollegeEmployee是局部变量
        // 改进： 此段代码放入 CollegeManager
//        List<CollegeEmployee> list1 = sub.getAllEmployee();
//        System.out.println("分公司员工");
//        for (CollegeEmployee collegeEmployee : list1) {
//            System.out.println(collegeEmployee.getId());
//        }
        sub.printAllEmployee();
        List< NewEmployee> list2 = getAllEmployee();
        System.out.println("总部员工");
        for (NewEmployee employee : list2) {
            System.out.println(employee.getId());
        }
    }
}