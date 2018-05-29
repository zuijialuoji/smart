package com.smart.service.impl;

import com.smart.core.service.Impl.ServiceImpl;
import com.smart.dao.sso.RoleDao;
import com.smart.dao.sso.UserRoleDao;
import com.smart.domain.sys.Role;
import com.smart.service.RoleService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;


@Log
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role, Long> implements RoleService {

    @Autowired
    public void setDao(RoleDao dao) {
        this.dao = dao;
    }

    @Autowired
    UserRoleDao userRoleDao;


    @Override
    public List<Role> list(Long userId) {
        List<Long> rolesIds = userRoleDao.listRoleId(userId);
        List<Role> roles = dao.condition(new HashMap<>(16));
        for (com.smart.domain.sys.Role Role : roles) {
            Role.setRoleSign("false");
            for (Long roleId : rolesIds) {
                if (Objects.equals(Role.getId(), roleId)) {
                    Role.setRoleSign("true");
                    break;
                }
            }
        }
        return roles;
    }

    @Override
    public List<Long> getRoleMenu(Long roleId) {
        return null;
    }
}
