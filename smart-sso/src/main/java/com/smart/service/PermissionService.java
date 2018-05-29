package com.smart.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 崔宗鲁 on 2018/5/26.
 *
 * @Description:
 */
public interface PermissionService {


    /**
     *
     * @param
     * @return 查询角色下
     */
    Set<String> roleUrl(Long roleId);

    Map<String,List<String>> buttonMap(Long roleId);

    Long getAppRole(Long userId ,String appCode);

}
