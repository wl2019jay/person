package com.jc.person.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.jc.person.module.Companies;
import com.jc.person.services.ICompaniesManageService;
import com.jc.person.vo.CompaniesVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(description = "公司管理类")
@RequestMapping("/companies")
public class CompaniesManagerController {

    @Autowired
    private ICompaniesManageService companiesManageService;

    @RequestMapping(value = "/queryAll",method = RequestMethod.POST)
    @ApiOperation(value = "查询公司", notes="查询公司 ")
    @ResponseBody
    public List<Companies> queryCompanies(@RequestBody CompaniesVO params)
    {
       return  companiesManageService.queryCompanies(params);
    }

    @RequestMapping(value = "/querCount",method = RequestMethod.POST)
    @ApiOperation(value = "查询公司总数", notes="查询公司总数")
    public int queryCount(@RequestBody CompaniesVO params)
    {
        return  companiesManageService.queryCount(params);
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value = "新增公司", notes="新增公司 ")
    @ResponseBody
    public JSONObject addCompanies(@RequestBody CompaniesVO params){
        companiesManageService.addCompanies(params);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        return result;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "新增公司", notes="新增公司 ")
    @ResponseBody
    public JSONObject updateCompanies(@RequestBody CompaniesVO params){
        companiesManageService.updateCompanies(params);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        return result;
    }

    @RequestMapping(value = "/queryByid/{pid}",method = RequestMethod.GET)
    @ApiOperation(value = "新增公司", notes="新增公司 ")
    @ResponseBody
    public Companies queryCompaniesById(@RequestParam("pid") int pid){
        Companies companies=companiesManageService.queryById(pid);
        return companies;
    }
    @RequestMapping(value = "/delete/{pid}",method = RequestMethod.GET)
    @ApiOperation(value = "新增公司", notes="新增公司 ")
    @ResponseBody
    public JSONObject deleteCompaniesById(@RequestParam("pid") int pid){
        companiesManageService.deleteCompanies(pid);
        JSONObject result=new JSONObject();
        result.put("code","0000");
        result.put("msg","success");
        return result;
    }
}
