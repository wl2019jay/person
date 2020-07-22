package com.jc.person.module;

/**
 * author:吴林
 * description：系统用户bean
 * date:2020-02-19
 */
public class SysUser extends Base {
    //主键
    private int pid;
    //用户名
    private String userName;
    //密码
    private String password;
    //电话号码
    private String phone;
    //邮件
    private String email;
    //备注
    private String remark;
    //问题提示
    private String tip;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

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
