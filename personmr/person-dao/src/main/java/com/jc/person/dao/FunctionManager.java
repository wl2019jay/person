package com.jc.person.dao;

import com.jc.person.module.Function;
import com.jc.person.module.RoleFunctionRef;
import com.jc.person.vo.FunctionTree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FunctionManager {

    /**
     * 新增功能
     * @param function
     */
    void  addFunction(Function function);

    /**
     * 新增角色功能
     * @param ref
     */
    void  addRoleFuction(RoleFunctionRef ref);

    /**
     * 批量新增角色功能
     * @param list
     */
    void addRoleFuctionBatch(List<RoleFunctionRef> list);

    /**
     * 查询功能数
     */
    List<FunctionTree> queryFunctionTree();

    /**
     * 修改功能
     * @param function
     */
    void  updateFunction(Function function);

    /**
     * 删除功能
     * @param pid
     */
    void deleteFunction(@Param("pid") int pid);

    /**
     * 清除角色功能
     * @param roleId
     */
    void deleteRoleFunction(@Param("roleId") int roleId);

    /**
     *
     * @param functionId
     * @return
     */
    Function queryFunctionById(@Param("functionId") int functionId);

}
