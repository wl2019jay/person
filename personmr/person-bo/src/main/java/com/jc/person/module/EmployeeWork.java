package com.jc.person.module;

/**
 * author：吴林
 * description：员工工作表
 * date:2020-02-19
 */
public class EmployeeWork extends Base {
    //员工id
    private int employeeId;
    //公司id
    private int companyId;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
    //冻结标识
    private String frozenFlag ;
    //是否已结算
    private  String isSettlement;
    //推荐记录id
    private  int recommendId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFrozenFlag() {
        return frozenFlag;
    }

    public void setFrozenFlag(String frozenFlag) {
        this.frozenFlag = frozenFlag;
    }

    public String getIsSettlement() {
        return isSettlement;
    }

    public void setIsSettlement(String isSettlement) {
        this.isSettlement = isSettlement;
    }

    public int getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(int recommendId) {
        this.recommendId = recommendId;
    }
}
