package com.jc.person.services;

import com.jc.person.module.SysUser;
import com.jc.person.vo.SysUserVO;

import java.util.List;

/**
 * author：吴林
 * description：系统用户接口类
 * date:2020-02-20
 */
public interface ISysUserManageService {
   /**
    * 单条新增
    * @param user  用户
    */
   void addUser(SysUserVO user);

   /**
    * 批量新增用户
    * @param users 用户列表
    */
   void addUserBatch(List<SysUserVO> users);

   /**
    * 批量修改用户
    * @param users 用户列表
    */
   void updateUserBatch(List<SysUserVO> users);

   /**
    * 根据用户id查询用户
    * @param userId  用户id
    */
   List<SysUserVO>  queryUserByid(int userId);

   /**
    * 更新用户密码
    * @param userCode 用户名称
    * @param oldUserPassord 原密码
    * @param newPassword 新密码
    */
   void   updateUserPassword(String userCode,String oldUserPassord,String newPassword);

   /**
    * 分页查询
    * @param pageIndex
    * @param pageSize
    * @return
    */
   List<SysUser> querUsers(int pageIndex, int pageSize);

   /**
    * 删除用户
    * @param userId
    */
   void  deleteUser(int userId);
}
