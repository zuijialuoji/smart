package com.smart.service;

import com.smart.core.service.Service;
import com.smart.domain.sys.Dept;
import com.smart.utils.Tree;

import java.util.Map;

public interface DeptService  extends Service<Dept, Long> {

    boolean checkDeptHasUser(Long deptId);

    int count(Map<String, Object> map);

    Tree<Dept> getTree();
}
