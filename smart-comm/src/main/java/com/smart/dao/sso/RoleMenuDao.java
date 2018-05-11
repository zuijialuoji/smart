package com.smart.dao.sso;

import com.smart.core.dao.Dao;
import com.smart.domain.sys.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 崔宗鲁 on 2018/5/11.
 *
 * @Description:
 */
@Mapper
@Repository
public interface RoleMenuDao extends Dao<RoleMenu, Long> {

    List<Long> listMenuIdByRoleId(Long roleId);
}
