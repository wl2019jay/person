package com.jc.person.dao;

import com.jc.person.module.Companies;
import com.jc.person.vo.CompaniesVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author：吴林
 * description：公司管理dao层
 * date:2020-02-22
 */
public interface CompaniesMr {

    /**
     * 新增公司
     * @param companies
     */
    void  addCompanies(Companies companies);

    /**
     * 查询公司
     * @param params
     */
    List<Companies> queryCompanies(CompaniesVO params);

    /**
     * 查询条数
     * @param params
     * @return
     */
    int  queryCount(CompaniesVO params);

    /**
     * 查询单条记录
     * @param companiesId
     * @return
     */
    Companies queryById( @Param("companiesId") int companiesId);

    /**
     * 修改公司
     * @param params
     */
    void updateCompanies(CompaniesVO params);

    /**
     * 删除公司
     * @param pid
     */
    void  deleteCompanies(int pid);
}
