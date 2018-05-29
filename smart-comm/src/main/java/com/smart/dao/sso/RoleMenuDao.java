package com.smart.dao.sso;

import com.smart.core.dao.Dao;
import com.smart.domain.sys.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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

    @Select(value = "SELECT distinct m.url FROM role_menu rm JOIN menu m ON rm.role_id=#{roleId} AND rm.menu_id=m.id AND m.type IN (1,2)")
    List<String> roleUrl(Long  roleId);

    /**
     *
     * @param roleId
     * @return 查出该角色下所有页菜单的url
     */
    @Select(value = "SELECT distinct m.url FROM role_menu rm JOIN menu m ON rm.role_id=#{roleId} AND rm.menu_id=m.id AND m.type IN (1)")
    List<String> selectPage(Long roleId);

    /**
     * 查询权限内该页面下所有的按钮
     * @return
     */
    @Select(value = "SELECT distinct m.url FROM role_menu rm JOIN menu m ON rm.role_id=#{arg0} AND rm.menu_id=m.id AND m.type IN (2) AND m.function_id =#{arg1} AND m.hide =0")
    List<String> selectBotton(Long roleId,String functionId);

    @Select(value = "SELECT m.id FROM role_menu  rm JOIN menu m ON rm.menu_id = m.id AND m.hide =0 AND rm.role_id =#{roleId}")
    List<Long> getRoleMenu(Long roleId);
}
