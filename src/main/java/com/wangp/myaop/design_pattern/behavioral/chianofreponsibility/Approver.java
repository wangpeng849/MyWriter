package com.wangp.myaop.design_pattern.behavioral.chianofreponsibility;

/**
 * <pre>
 * classname Approver
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 11:50
 **/
public abstract class Approver {

    protected Approver approver;

    public void setNextApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void deploy(Course course);
}
