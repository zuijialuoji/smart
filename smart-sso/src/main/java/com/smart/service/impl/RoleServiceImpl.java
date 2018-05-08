package com.smart.service.impl;

import com.smart.core.service.Impl.ServiceImpl;
import com.smart.dao.sso.RoleDao;
import com.smart.domain.sys.Role;
import com.smart.service.RoleService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Log
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role, Long> implements RoleService {

    @Autowired
    public void setDao(RoleDao dao) {
        this.dao = dao;
    }
}
