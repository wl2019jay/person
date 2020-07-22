package com.jc.person.services;

import com.jc.person.module.EmployeeIdCard;
import com.jc.person.module.Employees;
import com.jc.person.vo.EmployeeIdCardVO;
import com.jc.person.vo.EmployeesVO;

import java.util.List;

public interface IEmployeeManagerService {

    void addEmployees(EmployeesVO params);

    void updateEmployees(EmployeesVO params);

    List<Employees> queryAll(EmployeesVO params);

    int queryCount(EmployeesVO params);

    void deleteEmployees(EmployeesVO params);

    EmployeeIdCardVO vailidIdCard(EmployeeIdCardVO params);
}
