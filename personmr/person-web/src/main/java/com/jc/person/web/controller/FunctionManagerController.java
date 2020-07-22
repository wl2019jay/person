package com.jc.person.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.jc.person.module.Function;
import com.jc.person.module.RoleFunctionRef;
import com.jc.person.services.IFunctionManagerService;
import com.jc.person.vo.FunctionFaceVO;
import com.jc.person.vo.FunctionTree;
import com.jc.person.vo.FunctionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "功能定义")
@RequestMapping("/function")
public class FunctionManagerController {

    @Autowired
    private IFunctionManagerService functionManagerService;
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value = "新增功能", notes="新增功能 ")
    @ResponseBody
    public JSONObject  addFunction(@RequestBody FunctionVO functionVO){
        functionManagerService.addFunction(functionVO);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        return result;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "保存", notes="保存 ")
    @ResponseBody
    public JSONObject  save(@RequestBody FunctionFaceVO functionVO){
        functionManagerService.saveFunction(functionVO);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        return result;
    }

    @RequestMapping(value = "/addRoleFunction",method = RequestMethod.POST)
    @ApiOperation(value = "新增角色功能", notes="新增角色功能 ")
    @ResponseBody
    public JSONObject addRoleFuction(@RequestBody RoleFunctionRef ref){
        functionManagerService.addRoleFuction(ref);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        return result;
    }
    @RequestMapping(value = "/addRoleFunctionBatch",method = RequestMethod.POST)
    @ApiOperation(value = "批量新增角色功能", notes="批量新增角色功能 ")
    @ResponseBody
    public JSONObject addRoleFuctionBatch(@RequestBody List<RoleFunctionRef> functions){
        functionManagerService.addRoleFuctionBatch(functions);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        return result;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/tree",method = RequestMethod.POST)
    @ApiOperation(value = "功能树", notes="功能树 ")
    @ResponseBody
    public List<FunctionTree> queryFunctionTree(){
        List<FunctionTree> result= functionManagerService.queryFunctionTree();
        return result;

    }

    /**
     * 更新功能
     * @param functionVO
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "更新功能", notes="更新功能 ")
    @ResponseBody
    public JSONObject updateFunction(@RequestBody FunctionVO functionVO){
        functionManagerService.updateFunction(functionVO);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        return result;
    }



    @RequestMapping(value = "/deleteFunction",method = RequestMethod.POST)
    @ApiOperation(value = "删除功能", notes="删除功能 ")
    @ResponseBody
    public JSONObject deleteFunction(@RequestParam("pid")  String pid){
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        if(!StringUtils.isEmpty(pid)){
            int id=Integer.valueOf(pid);
            functionManagerService.deleteFunction(id);
        }else{
            result.put("code","-2");
            result.put("msg","主键为null");
        }
        return result;
    }


    @RequestMapping(value = "/queryById",method = RequestMethod.GET)
    @ApiOperation(value = "根据id查询功能", notes="根据id查询功能 ")
    @ResponseBody
    public Function queryById(@RequestParam("functionId")  int functionId){

        return functionManagerService.queryFunctionById(functionId);

    }

    @RequestMapping(value = "/clearFunction",method = RequestMethod.POST)
    @ApiOperation(value = "删除角色所有功能", notes="删除角色所有功能 ")
    @ResponseBody
    public JSONObject deleteRoleFunction(@RequestParam("roleId") String roleId){
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        if(!StringUtils.isEmpty(roleId)){
            int id=Integer.valueOf(roleId);
            functionManagerService.deleteRoleFunction(id);
        }else{
            result.put("code","-2");
            result.put("msg","主键为null");
        }
        return result;
    }
}
