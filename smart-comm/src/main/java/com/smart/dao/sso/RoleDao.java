package com.smart.dao.sso;

import com.smart.core.dao.Dao;
import com.smart.domain.sys.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface RoleDao extends Dao<Role, Long> {

}
