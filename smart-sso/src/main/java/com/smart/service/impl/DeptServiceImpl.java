package com.smart.service.impl;

import com.smart.core.service.Impl.ServiceImpl;
import com.smart.dao.sso.DeptDao;
import com.smart.domain.sys.Dept;
import com.smart.service.DeptService;
import com.smart.utils.BuildTree;
import com.smart.utils.Tree;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Log
@Service
public class DeptServiceImpl extends ServiceImpl<DeptDao, Dept, Long> implements DeptService {

    @Autowired
    public void setDao(DeptDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean checkDeptHasUser(Long deptId) {
        // TODO Auto-generated method stub
        //查询部门以及此部门的下级部门
        int result = dao.getDeptUserNumber(deptId);
        return result==0?true:false;
    }

    @Override
    public int count(Map<String, Object> map){
        return dao.count(map);
    }


    @Override
    public Tree<Dept> getTree() {
        List<Tree<Dept>> trees = new ArrayList<Tree<Dept>>();
        List<Dept> sysDepts = dao.condition(new HashMap<String,Object>(16));
        for (Dept sysDept : sysDepts) {
            Tree<Dept> tree = new Tree<Dept>();
            tree.setId(sysDept.getId().toString());
            tree.setParentId(sysDept.getParentId().toString());
            tree.setText(sysDept.getName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            tree.setState(state);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<Dept> t = BuildTree.build(trees);
        return t;
    }
}
