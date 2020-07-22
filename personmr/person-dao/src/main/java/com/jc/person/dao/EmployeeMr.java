package com.jc.person.dao;

import com.jc.person.module.EmployeeIdCard;
import com.jc.person.module.Employees;
import com.jc.person.module.EmployeesEconomicmanRef;
import com.jc.person.vo.EmployeesVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMr {
    /**
     * 新增员工
     * @param employees
     */
    void addEmployees(Employees employees);

    /**
     * 新增员工身份证
     * @param employeeIdCard
     */
    void addEmployeesIdCard(EmployeeIdCard employeeIdCard);

    /**
     * 新增经济人
     * @param ref
     */
    void addEmployeesRef(EmployeesEconomicmanRef ref);

    /**
     * 更新员工
     * @param employees
     */
    void updateEmployees(Employees employees);

    /**
     * 更新员工身份证
     * @param employeeIdCard
     */
    void updateEmployeesIdCard(EmployeeIdCard employeeIdCard);

    /**
     * 新增员工经济人
     * @param ref
     */
    void updateEmployeesRef(EmployeesEconomicmanRef ref);

    /**
     * 查询列表
     * @param params
     * @return
     */
    List<Employees> queryAll(EmployeesVO params);

    /**
     * 查询列表总数
     * @param params
     * @return
     */
    int queryCount(EmployeesVO params);

    /**
     * 根据id查询单条记录
     * @param pid
     * @return
     */
    EmployeesVO queryByid(@Param("pid") int pid);

    /**
     * 删除记录
     * @param pid
     */
    void deleteEmployees(@Param("pid") int pid);
}
