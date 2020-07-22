package com.jc.person.service.impl;

import com.jc.person.dao.CompaniesMr;
import com.jc.person.module.Companies;
import com.jc.person.services.ICompaniesManageService;
import com.jc.person.vo.CompaniesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompaniesManageService implements ICompaniesManageService {
    @Autowired
    private CompaniesMr companiesMr;
    @Override
    public void addCompanies(CompaniesVO companies) {
        Companies companies1=new Companies();
        BeanUtils.copyProperties(companies,companies1);
        companiesMr.addCompanies(companies1);
    }

    @Override
    public List<Companies> queryCompanies(CompaniesVO params) {
        return companiesMr.queryCompanies(params);
    }

    @Override
    public int queryCount(CompaniesVO params) {
        return companiesMr.queryCount(params);
    }

    @Override
    public Companies queryById(int companiesId) {
        return companiesMr.queryById(companiesId);
    }

    @Override
    public void updateCompanies(CompaniesVO params) {
        companiesMr.updateCompanies(params);
    }

    @Override
    public void deleteCompanies(int pid) {
        companiesMr.deleteCompanies(pid);
    }
}
