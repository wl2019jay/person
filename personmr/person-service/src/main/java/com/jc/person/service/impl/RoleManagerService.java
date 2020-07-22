package com.jc.person.service.impl;

import com.jc.person.dao.RoleManager;
import com.jc.person.module.Role;
import com.jc.person.module.UserRoleRef;
import com.jc.person.services.IRoleManagerService;
import com.jc.person.vo.RoleFaceVO;
import com.jc.person.vo.RoleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
@Service
public class RoleManagerService implements IRoleManagerService {
    @Autowired
    private RoleManager roleManager;

    @Override
    public void saveRole(RoleFaceVO roleFaceVO) {
        if(!CollectionUtils.isEmpty(roleFaceVO.getNewItem())){
            for (Role role:roleFaceVO.getNewItem()) {
                roleManager.addRoles(role);
            }
        }
        if(!CollectionUtils.isEmpty(roleFaceVO.getUpdateItem()))
        {
            for (Role role:roleFaceVO.getUpdateItem()) {
                roleManager.updateRole(role);
            }
        }

        if(!CollectionUtils.isEmpty(roleFaceVO.getRemoveItem())){
            for (Role role:roleFaceVO.getRemoveItem()) {
                roleManager.deleteRole(role.getPid());
            }
        }
    }

    @Override
    public void addRoles(RoleVO role) {
        Role item =new Role();
        BeanUtils.copyProperties(role,item);
        roleManager.addRoles(item);
    }

    @Override
    public void addUserRole(UserRoleRef ref) {
        roleManager.addUserRole(ref);
    }

    @Override
    public void updateRoleRef(UserRoleRef ref) {
        roleManager.updateRoleRef(ref);
    }

    @Override
    public void updateRole(RoleVO role) {
       Role item =new Role();
       BeanUtils.copyProperties(role,item);
        roleManager.updateRole(item);
    }

    @Override
    public void deleteUserRoleRef(int pid) {
        roleManager.deleteUserRoleRef(pid);
    }

    @Override
    public void deleteRole(int pid) {
        roleManager.deleteRole(pid);
    }

    @Override
    public List<Role> queryAll(RoleVO role) {
        Role item=new Role();
        BeanUtils.copyProperties(role,item);
        return roleManager.queryAll(item);
    }

    @Override
    public int queryCount(RoleVO role) {
        Role item=new Role();
        BeanUtils.copyProperties(role,item);
        return roleManager.queryCount(item);
    }
}
