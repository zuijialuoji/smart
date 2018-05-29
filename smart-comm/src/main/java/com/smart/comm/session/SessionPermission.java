package com.smart.comm.session;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ：崔
 * @commons.core.session
 * @Description:记录已登录用户权限信息
 */
@Data
public class SessionPermission implements Serializable {

    private static final long serialVersionUID = 7744061178030182892L;


    // 用户权限
    private Set<String> permissionSet;
    //按钮
    private Map<String, List<String>> buttonMap;

}