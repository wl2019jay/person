package com.jc.person.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.jc.person.module.Role;
import com.jc.person.module.UserRoleRef;
import com.jc.person.services.IRoleManagerService;
import com.jc.person.vo.RoleFaceVO;
import com.jc.person.vo.RoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(description = "角色管理")
public class RoleManagerController {

    @Autowired
    private IRoleManagerService roleManagerService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value = "新增角色", notes="新增角色 ")
    @ResponseBody
    public JSONObject addRole(@RequestBody RoleVO roleVO)
    {
        roleManagerService.addRoles(roleVO);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        return result;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "保存角色", notes="保存角色 ")
    @ResponseBody
    public JSONObject addRole(@RequestBody RoleFaceVO roleVO)
    {
        roleManagerService.saveRole(roleVO);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        return result;
    }

    @RequestMapping(value = "/addUserRole",method = RequestMethod.POST)
    @ApiOperation(value = "新增用户角色", notes="新增用户角色 ")
    @ResponseBody
    public JSONObject addUserRole(@RequestBody UserRoleRef ref)
    {
        roleManagerService.addUserRole(ref);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        return result;
    }

    @RequestMapping(value = "/updateUserRole",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户角色", notes="修改用户角色 ")
    @ResponseBody
    public JSONObject updateRoleRef(@RequestBody UserRoleRef ref)
    {
        roleManagerService.updateRoleRef(ref);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        return result;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "修改角色", notes="修改角色 ")
    @ResponseBody
    public JSONObject updateRole(@RequestBody RoleVO roleVO)
    {
        roleManagerService.updateRole(roleVO);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        return result;
    }

    @RequestMapping(value = "/deleteUserRole",method = RequestMethod.POST)
    @ApiOperation(value = "删除用户角色", notes="删除用户角色 ")
    @ResponseBody
    public JSONObject deleteUserRoleRef(@RequestParam("pid") String pid){
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        if(!StringUtils.isEmpty(pid)){
            int id=Integer.valueOf(pid);
            roleManagerService.deleteUserRoleRef(id);
        }else{
            result.put("code","-2");
            result.put("msg","主键为null");
        }
        return result;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ApiOperation(value = "删除角色", notes="删除角色 ")
    @ResponseBody
    public JSONObject deleteRole(@RequestParam("pid") String pid){
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        if(!StringUtils.isEmpty(pid)){
            int id=Integer.valueOf(pid);
            roleManagerService.deleteRole(id);
        }else{
            result.put("code","-2");
            result.put("msg","主键为null");
        }
        return result;
    }
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    @ApiOperation(value = "查询角色", notes="查询角色 ")
    @ResponseBody
    public List<Role> queryAll(RoleVO roleVO){
        return roleManagerService.queryAll(roleVO);
    }

    @RequestMapping(value = "/queryCount",method = RequestMethod.POST)
    @ApiOperation(value = "查询角色个数", notes="查询角色个数 ")
    @ResponseBody
    public JSONObject queryCount(RoleVO roleVO){
        JSONObject result =new JSONObject();
        int count=roleManagerService.queryCount(roleVO);
        result.put("count",count);
        return result;
    }

}
