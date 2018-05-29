package com.smart.service;

import com.smart.core.service.Service;
import com.smart.domain.sys.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleService  extends Service<Role, Long> {

    List<Role> list(Long userId);

    List<Long> getRoleMenu(Long roleId);
}
