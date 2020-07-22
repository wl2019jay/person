package com.jc.person.service.impl;

import com.jc.person.services.ISysUserManageService;
import com.jc.person.module.SysUser;
import com.jc.person.vo.SysUserVO;
import com.jc.person.dao.SysUsermr;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysUserManageServiceImpl implements ISysUserManageService {

    @Autowired
    private SysUsermr sysUsermrDao;

    public void addUser(SysUserVO user) {
        SysUser userModel= new SysUser();
        BeanUtils.copyProperties(user,userModel);
        sysUsermrDao.addUser(userModel);
    }

    public void addUserBatch(List<SysUserVO> users) {

    }

    public void updateUserBatch(List<SysUserVO> users) {

    }

    public List<SysUserVO> queryUserByid(int userId) {
        return null;
    }

    public void updateUserPassword(String userCode, String oldUserPassord, String newPassword) {

    }

    public List<SysUser> querUsers(int pageIndex, int pageSize) {
        return sysUsermrDao.querUsers(pageIndex,pageSize);
    }

    public void deleteUser(int userId) {

    }
}
