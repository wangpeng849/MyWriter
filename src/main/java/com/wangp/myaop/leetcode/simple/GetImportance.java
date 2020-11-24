package com.wangp.myaop.leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * classname GetImportance
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/11/24 17:21
 **/
public class GetImportance {

    public int getImportance(List<Employee> employees, int id) {
//        Map<Integer, Employee> employeeMap = employees.stream()
//                .collect(Collectors.toMap(Employee::getId, Function.identity()));
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        return dfs(employeeMap, employeeMap.get(id));
    }

    private int dfs(Map<Integer, Employee> employeeMap, Employee employee) {
        int ans = 0;
        if (employee.subordinates.size() == 0) {
            return employee.importance;
        }
        for (Integer subordinate : employee.subordinates) {
            ans += dfs(employeeMap, employeeMap.get(subordinate));
        }
        return ans + employee.importance;
    }

    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();

        ArrayList list4 = new ArrayList();
        list4.add(2);
        list4.add(3);
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        Employee e3 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = list4;
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = list1;
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = list2;
        System.out.println(new GetImportance().getImportance(Arrays.asList(e1, e2, e3), 1));
    }
}

class Employee {

    public int id;
    public int importance;
    public List<Integer> subordinates;
}