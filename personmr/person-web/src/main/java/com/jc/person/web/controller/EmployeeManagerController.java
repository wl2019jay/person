package com.jc.person.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.jc.person.module.Employees;
import com.jc.person.services.IEmployeeManagerService;
import com.jc.person.vo.CompaniesVO;
import com.jc.person.vo.EmployeeIdCardVO;
import com.jc.person.vo.EmployeesVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "员工管理类")
@RequestMapping("/employee")
public class EmployeeManagerController {
    @Autowired
    private IEmployeeManagerService employeeManagerService;

    @RequestMapping(value = "/queryAll",method = RequestMethod.POST)
    @ApiOperation(value = "查询员工", notes="查询员工")
    @ResponseBody
    public List<Employees> queryEmployees(@RequestBody EmployeesVO params)
    {
        return  employeeManagerService.queryAll(params);
    }
    @RequestMapping(value = "/querCount",method = RequestMethod.POST)
    @ApiOperation(value = "查询员工总数", notes="查询员工总数")
    public int queryCount(@RequestBody EmployeesVO params)
    {
        return  employeeManagerService.queryCount(params);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value = "新增员工", notes="新增员工 ")
    @ResponseBody
    public JSONObject addCompanies(@RequestBody EmployeesVO params){
        employeeManagerService.addEmployees(params);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        return result;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "修改员工", notes="修改员工 ")
    @ResponseBody
    public JSONObject updateCompanies(@RequestBody EmployeesVO params){
        employeeManagerService.updateEmployees(params);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        return result;
    }

    @RequestMapping(value = "/valide/idcard",method = RequestMethod.POST)
    @ApiOperation(value = "识别身份证", notes="识别身份证 ")
    @ResponseBody
    public EmployeeIdCardVO valideCard(@RequestBody EmployeeIdCardVO params){
        return employeeManagerService.vailidIdCard(params);
    }
}
