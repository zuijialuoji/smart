package com.smart.comm.session;

import com.smart.domain.sys.Menu;
import com.smart.domain.sys.Role;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 崔宗鲁 on 2018/5/26.
 *
 * @Description:
 */
@Data
public class StaticPermission {

    private static  Set<String> permissionSet ;

    /**
     * 所有权限的集合
     */
    private static Map<Integer,Set<String>> rolePermission;
    /**
     * 各种角色下的菜单按钮
     */
    private static Map<Integer,Map<String,List<String>>> menuButton;




}
