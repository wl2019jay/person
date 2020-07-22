package com.jc.person.web.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@Api(description = "测试接口")
@RestController
@ResponseBody
@RequestMapping("/test")
public class TestController {
    @ApiOperation(value = "测试", notes="测试 ")
    @RequestMapping(value = "/m1",method= RequestMethod.GET)
    public Map<String,String> test(){
        Map<String,String> maps =new HashMap<String,String>();
        maps.put("aaa","dddd");
        maps.put("bbbb","eeeee");
        return  maps;
    }
}
