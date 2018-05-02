package com.smart.service.impl;

import com.smart.core.service.Impl.ServiceImpl;
import com.smart.dao.RoleDao;
import com.smart.domain.sys.Role;
import com.smart.service.RoleService;
import lombok.extern.log4j.Log4j;

@Log4j
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role, Long> implements RoleService {
}
