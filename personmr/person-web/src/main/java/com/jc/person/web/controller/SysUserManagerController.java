package com.jc.person.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.jc.person.module.SysUser;
import com.jc.person.services.ISysUserManageService;
import com.jc.person.vo.SysUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(description = "系统用户类")
@RequestMapping("/sysuser")
public class SysUserManagerController {
    @Autowired
    private ISysUserManageService sysUserManageService;
    @ApiOperation(value = "添加用户", notes="添加用户 ")
//    @ApiImplicitParam(name = "users", value = "用户详细实体user", required = true, dataType = "com.jc.person.vo.SysUserVO")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addUser(@Valid  @RequestBody SysUserVO users){
        sysUserManageService.addUser(users);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
       return result;
    }
    @ApiOperation(value = "查询用户", notes="查询用户 ")
//    @ApiImplicitParam(name = "users", value = "用户详细实体user", required = true, dataType = "com.jc.person.vo.SysUserVO")
    @RequestMapping(value = "/queeryUsers",method = RequestMethod.POST)
    @ResponseBody
    public List<SysUser> queryUser(){
        return sysUserManageService.querUsers(0,0);
    }
}
