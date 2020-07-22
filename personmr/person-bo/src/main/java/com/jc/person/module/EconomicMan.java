package com.jc.person.module;

/**
 * author：吴林
 * description：经济人类
 * date:2020-02-19
 */
public class EconomicMan extends Base{
    //用户id
    private int userId;
    //电话
    private String phone;
    //备注
    private String remark;

    //身份证照片
    private  String idImage;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }
}
