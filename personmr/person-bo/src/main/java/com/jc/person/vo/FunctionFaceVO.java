package com.jc.person.vo;

import com.jc.person.module.Function;

import java.util.List;

public class FunctionFaceVO {

    private List<Function> newItem;

    private List<Function> updateItem;

    private List<Function> removeItem;

    public List<Function> getNewItem() {
        return newItem;
    }

    public void setNewItem(List<Function> newItem) {
        this.newItem = newItem;
    }

    public List<Function> getUpdateItem() {
        return updateItem;
    }

    public void setUpdateItem(List<Function> updateItem) {
        this.updateItem = updateItem;
    }

    public List<Function> getRemoveItem() {
        return removeItem;
    }

    public void setRemoveItem(List<Function> removeItem) {
        this.removeItem = removeItem;
    }
}
