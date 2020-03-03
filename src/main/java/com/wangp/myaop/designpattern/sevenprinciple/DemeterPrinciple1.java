package com.wangp.myaop.designpattern.sevenprinciple;

import lombok.Data;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class DemeterPrinciple1 {
    public static void main(String[] args) {
        new SchoolManager().printAllEmployee(new CollegeManager());
    }
}

@Data
class Employee{
    private String id;
}

@Data
class CollegeEmployee{
    private String id;
}

class CollegeManager{
    public List<CollegeEmployee> getAllEmployee(){
        List<CollegeEmployee> list = new ArrayList<>();
        for(int i = 0;i<10;i++){
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工id:"+i);
            list.add(emp);
        }
        return list;
    }
}

//SchoolManager的直接朋友： Employee   CollegeManager
//               非直接朋友：CollegeEmployee  违背迪米特法则
class SchoolManager{
    public List<Employee> getAllEmployee(){
        List<Employee> list = new ArrayList<>();
        for(int i = 0;i<5;i++){
            Employee emp = new Employee();
            emp.setId("学校总部员工id:"+i);
            list.add(emp);
        }
        return list;
    }

    void printAllEmployee(CollegeManager sub){

        //1. 此处的CollegeEmployee不是 SchoolManager的直接朋友
        //2. CollegeEmployee是局部变量
        List<CollegeEmployee> list1 = sub.getAllEmployee();
        System.out.println("分公司员工");
        for (CollegeEmployee collegeEmployee : list1) {
            System.out.println(collegeEmployee.getId());
        }
        List<Employee> list2 = getAllEmployee();
        System.out.println("总部员工");
        for (Employee employee : list2) {
            System.out.println(employee.getId());
        }
    }
}