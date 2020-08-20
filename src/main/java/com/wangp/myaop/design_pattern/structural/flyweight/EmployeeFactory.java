package com.wangp.myaop.design_pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * classname EmployeeFactory
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/20 22:08
 **/
public class EmployeeFactory {

    private final static Map<String, Employee> EMPLOYEE_MAP = new HashMap<>();

    public static Employee getManager(String departmant) {
        Manager manager = (Manager) EMPLOYEE_MAP.get(departmant);

        if (manager == null) {
            manager = new Manager(departmant);
            EMPLOYEE_MAP.put(departmant, manager);
            System.out.println("创建部门经理：" + departmant);
            String reportContent = departmant + "此次报告的主要内容是...";
            manager.setReportContent(reportContent);
            System.out.println("创建报告：" + reportContent);
        }
        return manager;
    }
}
