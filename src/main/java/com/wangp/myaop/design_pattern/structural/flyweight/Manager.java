package com.wangp.myaop.design_pattern.structural.flyweight;

/**
 * <pre>
 * classname Manage
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/20 22:06
 **/
public class Manager implements Employee {

    private String department;
    private String reportContent;

    public Manager(String department) {
        this.department = department;
    }

    @Override
    public void report() {
        System.out.println(reportContent);
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
}
