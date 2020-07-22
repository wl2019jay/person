package com.jc.person.vo;

public class EmployeesVO  extends BaseVO{
    //员工编码
    private String employeeCode;
    //员工名称
    private String name;
    //电话号码
    private String phone;
    //电子邮箱
    private  String email;
    //城市
    private int cityId;
    //详细地址
    private String address;
    //身份证信息
    private EmployeeIdCardVO idNum;

    private EmployeesEcibinucnabRefVO refVO;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeIdCardVO getIdNum() {
        return idNum;
    }

    public void setIdNum(EmployeeIdCardVO idNum) {
        this.idNum = idNum;
    }

    public EmployeesEcibinucnabRefVO getRefVO() {
        return refVO;
    }

    public void setRefVO(EmployeesEcibinucnabRefVO refVO) {
        this.refVO = refVO;
    }
}
