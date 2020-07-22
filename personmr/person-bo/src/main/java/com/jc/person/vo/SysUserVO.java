package com.jc.person.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SysUserVO {
    //用户名
    @NotNull
//    @Pattern(regexp = "/^[-_a-zA-Z0-9]{4,16}$/",message = "4到16位（字母，数字，下划线，减号）")
    private String userName;
    //密码
//    @Pattern(regexp ="/^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/",message = "至少8个字符，至少1个大写字母，1个小写字母和1个数字,不能包含特殊字符（非数字字母）")
    @NotNull
    private String password;
    //电话号码
    @NotNull
//    @Pattern(regexp = "/^([1]\\d{10}|([\\(（]?0[0-9]{2,3}[）\\)]?[-]?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)$/",message = "电话号码有误")
    private String phone;
    //邮件
    private String email;
    //备注
    private String remark;
    //问题提示
    private String tip;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
