package com.jc.person.vo;

import com.jc.person.module.Role;

import java.util.List;

public class RoleFaceVO {

    private List<Role> newItem;

    private List<Role> updateItem;

    private List<Role> removeItem;

    public List<Role> getNewItem() {
        return newItem;
    }

    public void setNewItem(List<Role> newItem) {
        this.newItem = newItem;
    }

    public List<Role> getUpdateItem() {
        return updateItem;
    }

    public void setUpdateItem(List<Role> updateItem) {
        this.updateItem = updateItem;
    }

    public List<Role> getRemoveItem() {
        return removeItem;
    }

    public void setRemoveItem(List<Role> removeItem) {
        this.removeItem = removeItem;
    }
}
