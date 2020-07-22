package com.jc.person.module;

/**
 * author:吴林
 * description :计费模板类
 * date:2020-02-19
 */
public class CostMode extends Base {
    //模板编码
    private String modelCode;
    //模板名称
    private String modelName;
    //计费类型
    private String costType;
    //计费单价
    private String costSinglePrice;
    //备注
    private String remark;

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getCostSinglePrice() {
        return costSinglePrice;
    }

    public void setCostSinglePrice(String costSinglePrice) {
        this.costSinglePrice = costSinglePrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
