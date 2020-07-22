package com.jc.person.service.impl;

import com.jc.person.dao.EmployeeMr;
import com.jc.person.module.EmployeeIdCard;
import com.jc.person.module.Employees;
import com.jc.person.services.IEmployeeManagerService;
import com.jc.person.util.IDCardDetect;
import com.jc.person.vo.EmployeeIdCardVO;
import com.jc.person.vo.EmployeesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManagerService implements IEmployeeManagerService {
    @Autowired
    private EmployeeMr employeeMr;
    @Override
    public void addEmployees(EmployeesVO params) {
        Employees employees=new Employees();

    }

    @Override
    public void updateEmployees(EmployeesVO params) {

    }

    @Override
    public List<Employees> queryAll(EmployeesVO params) {
       return  employeeMr.queryAll(params);
    }

    @Override
    public int queryCount(EmployeesVO params) {
        return employeeMr.queryCount(params);
    }

    @Override
    public void deleteEmployees(EmployeesVO params) {

    }

    @Override
    public EmployeeIdCardVO vailidIdCard(EmployeeIdCardVO params) {
        EmployeeIdCardVO result=IDCardDetect.detect(params.getFrontImage(),params.getBackImage());
        result.setBackImage(params.getBackImage());
        result.setFrontImage(params.getFrontImage());
       return result;
    }
}
