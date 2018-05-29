package com.smart.service.impl;

import com.smart.dao.sso.RoleMenuDao;
import com.smart.dao.sso.UserRoleDao;
import com.smart.service.PermissionService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by 崔宗鲁 on 2018/5/26.
 *
 * @Description:
 */
@Log
@Service
public class permissionServiceImpl implements PermissionService {
    @Autowired
    private RoleMenuDao roleMenuDao;

    @Autowired
    private UserRoleDao userRoleDao;

    /**
     * 用户权限
     */
    private Set<String> permissionSet;

    @Value("1")
    private String appCode;

    /**
     * 所有权限的集合
     */
    private static Map<Integer,Set<String>> rolePermission;
    /**
     * 各种角色下的菜单按钮
     */
    private static Map<Integer,Map<String,List<String>>> menuButton;


    /**
     *
     * @param roleId
     * @return 获取该角色下的权限
     */
    @Override
    public Set<String> roleUrl(Long roleId) {
        List<String> urls =roleMenuDao.roleUrl(roleId);
        Set<String> urlSet = new HashSet<String>(urls);
        return urlSet;
    }

    /**
     *
     * @param roleId
     * @return 获取具体角色下的页菜单里面的按钮总汇
     */
    @Override
    public Map<String, List<String>> buttonMap(Long roleId) {
        Map<String, List<String>> buttonMap =new HashMap<String, List<String>>();
        List<String> functionIds =roleMenuDao.selectPage(roleId);
        for(String f :functionIds){
            buttonMap.put(f,roleMenuDao.selectBotton(roleId,f));
        }
        return buttonMap;
    }

    /**
     *
     * @param appCode
     * @return 获取该系统下该用户的角色id
     */
    @Override
    public Long getAppRole(Long userId ,String appCode){
        return userRoleDao.getAppRole(userId,appCode).getRoleId();
    }


}
