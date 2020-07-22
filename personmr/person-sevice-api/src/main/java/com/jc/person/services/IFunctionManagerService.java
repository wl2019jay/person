package com.jc.person.services;

import com.jc.person.module.Function;
import com.jc.person.module.RoleFunctionRef;
import com.jc.person.vo.FunctionFaceVO;
import com.jc.person.vo.FunctionTree;
import com.jc.person.vo.FunctionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IFunctionManagerService {

    /**
     * 新增功能
     * @param function
     */
    void  addFunction(FunctionVO function);

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
    void  updateFunction(FunctionVO function);

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
     * 保存功能
     * @param functionFaceVO
     */
    void saveFunction(FunctionFaceVO functionFaceVO);

    /**
     * 根据id查询功能
     * @param functionId
     * @return
     */
    Function queryFunctionById(int functionId);
}
