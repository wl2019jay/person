package com.jc.person.vo;

import javax.validation.constraints.NotNull;

public class CompaniesVO extends  BaseVO {

    //公司编码
    private String companyCode;
    //公司名称
    @NotNull
    private  String companyName;
    //公司描述
    @NotNull
    private String companyDesc;
    //宣全照片
    private String image;
    //地址
    private String address;
    //联系电话
    @NotNull
    private String tellPhone;
    //计费方式
    @NotNull
    private int ostModeId;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTellPhone() {
        return tellPhone;
    }

    public void setTellPhone(String tellPhone) {
        this.tellPhone = tellPhone;
    }

    public int getOstModeId() {
        return ostModeId;
    }

    public void setOstModeId(int ostModeId) {
        this.ostModeId = ostModeId;
    }
}
