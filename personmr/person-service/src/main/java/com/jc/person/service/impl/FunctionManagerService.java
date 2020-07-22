package com.jc.person.service.impl;

import com.jc.person.dao.FunctionManager;
import com.jc.person.module.Function;
import com.jc.person.module.RoleFunctionRef;
import com.jc.person.services.IFunctionManagerService;
import com.jc.person.vo.FunctionFaceVO;
import com.jc.person.vo.FunctionTree;
import com.jc.person.vo.FunctionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
@Service
public class FunctionManagerService implements IFunctionManagerService {
    @Autowired
    private FunctionManager functionManager;
    @Override
    public void addFunction(FunctionVO function) {
        Function  item =new Function();
        BeanUtils.copyProperties(function,item);
        functionManager.addFunction(item);
    }

    @Override
    public void addRoleFuction(RoleFunctionRef ref) {
        functionManager.addRoleFuction(ref);
    }

    @Override
    public void addRoleFuctionBatch(List<RoleFunctionRef> list) {
        functionManager.addRoleFuctionBatch(list);
    }

    @Override
    public List<FunctionTree> queryFunctionTree() {
        List<FunctionTree> result= functionManager.queryFunctionTree();
        setIcon(result);
        return result;
    }

    public  void  setIcon(List<FunctionTree> items){
        for (FunctionTree item:items) {
            if(CollectionUtils.isEmpty(item.getChildren())){
                 item.setIcon("el-icon-document");
            }else{
                item.setIcon("el-icon-folder");
                setIcon(item.getChildren());
            }
        }
    }

    @Override
    public void updateFunction(FunctionVO function) {
        Function  item =new Function();
        BeanUtils.copyProperties(function,item);
        functionManager.updateFunction(item);
    }

    @Override
    public void deleteFunction(int pid) {
        functionManager.deleteFunction(pid);
    }

    @Override
    public void deleteRoleFunction(int roleId) {
        functionManager.deleteRoleFunction(roleId);
    }

    @Override
    public void saveFunction(FunctionFaceVO functionFaceVO) {
        if(!CollectionUtils.isEmpty(functionFaceVO.getNewItem())){
            for (Function function:functionFaceVO.getNewItem()) {
                functionManager.addFunction(function);
            }
        }
        if(!CollectionUtils.isEmpty(functionFaceVO.getUpdateItem()))
        {
            for (Function function:functionFaceVO.getUpdateItem()) {
                functionManager.updateFunction(function);
            }
        }

        if(!CollectionUtils.isEmpty(functionFaceVO.getRemoveItem())){
            for (Function function:functionFaceVO.getRemoveItem()) {
                functionManager.deleteFunction(function.getPid());
            }
        }
    }

    @Override
    public Function queryFunctionById(int functionId) {
        return functionManager.queryFunctionById(functionId);
    }
}
