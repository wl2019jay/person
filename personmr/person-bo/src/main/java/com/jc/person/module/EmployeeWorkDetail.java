package com.jc.person.module;

public class EmployeeWorkDetail extends Base {
    //工作记录ID
    private int workId;
    //工作日期
    private String workDate;
    //工作小时数
    private double workHours;

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double workHours) {
        this.workHours = workHours;
    }
}
