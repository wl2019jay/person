package com.jc.person.module;

/**
 * author：吴林
 * description：经济人与员工关系表
 */
public class EmployeesEconomicmanRef extends Base{
    //员工id
    private int employeeId;
    //经济人id
    private int economicManId;
    //推荐ID
    private int recommendDate;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEconomicManId() {
        return economicManId;
    }

    public void setEconomicManId(int economicManId) {
        this.economicManId = economicManId;
    }

    public int getRecommendDate() {
        return recommendDate;
    }

    public void setRecommendDate(int recommendDate) {
        this.recommendDate = recommendDate;
    }
}
