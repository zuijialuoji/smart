package com.smart.service.impl;

import com.smart.core.service.Impl.ServiceImpl;
import com.smart.dao.sso.DeptDao;
import com.smart.domain.sys.Dept;
import com.smart.service.DeptService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Log
@Service
public class DeptServiceImpl extends ServiceImpl<DeptDao, Dept, Long> implements DeptService {

    @Autowired
    public void setDao(DeptDao dao) {
        this.dao = dao;
    }
}
