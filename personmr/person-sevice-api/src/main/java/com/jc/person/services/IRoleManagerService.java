package com.jc.person.services;

import com.jc.person.module.Role;
import com.jc.person.module.UserRoleRef;
import com.jc.person.vo.RoleFaceVO;
import com.jc.person.vo.RoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IRoleManagerService {

    /**
     * 保存角色
     * @param roleFaceVO
     */
   void saveRole(RoleFaceVO roleFaceVO);

    /**
     * 创建角色
     */
    void addRoles(RoleVO role);

    /**
     * 添加用户角色关联
     * @param ref
     */
    void addUserRole(UserRoleRef ref);

    /**
     * 更新角色
     * @param ref
     */
    void updateRoleRef(UserRoleRef ref);

    /**
     * 更新角色
     */
    void updateRole(RoleVO role);

    /**
     * 删除用户角色
     * @param pid
     */
    void deleteUserRoleRef(@Param("pid") int pid);

    /**
     * 删除角色
     * @param pid
     */
    void deleteRole(@Param("pid") int pid);

    /**
     * 查询所有角色
     * @param role
     * @return
     */
    List<Role> queryAll(RoleVO role);

    /**
     * 查询角色个数
     * @param role
     * @return
     */
    int queryCount(RoleVO role);
}
