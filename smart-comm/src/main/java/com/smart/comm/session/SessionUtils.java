package com.smart.comm.session;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 崔宗鲁 on 2018/5/26.
 *
 * @Description:
 */
public class SessionUtils {
    /**
     * 用户信息
     */
    public static final String SESSION_ROLE = "roleIds";
    /**
     * 用户信息
     */
    public static final String SESSION_ID = "id";

    public static final String PERMISSION_SET ="permissionSet";

    public static final String BUTTON_MAP ="buttonMap";
    private Set<String> permissionSet;
    //按钮
    private Map<String, List<String>> buttonMap;



    public static Long getSessionId(HttpServletRequest request) {
        return  (Long) request.getSession().getAttribute(SESSION_ID);
    }
    public static void setSessionId(HttpServletRequest request, Long id){
        request.getSession().setAttribute(SESSION_ID, id);
    }
    public static List<Long> getSessionRole(HttpServletRequest request) {
        return  (List<Long>) request.getSession().getAttribute(SESSION_ROLE);
    }

    public static void setSessionRole(HttpServletRequest request, List<Long> roleIds) {
        request.getSession().setAttribute(SESSION_ROLE, roleIds);
    }

    public static Set<String> getPermissionSet(HttpServletRequest request) {
        return  (Set<String>) request.getSession().getAttribute(PERMISSION_SET);
    }

    public static void setPermissionSet(HttpServletRequest request, Set<String> permissionSet) {
        request.getSession().setAttribute(PERMISSION_SET, permissionSet);
    }

    public static Map<String, List<String>> getButtonMap(HttpServletRequest request) {
        return  (Map<String, List<String>>) request.getSession().getAttribute(BUTTON_MAP);
    }

    public static void setButtonMap(HttpServletRequest request, Map<String, List<String>> buttonMap) {
        request.getSession().setAttribute(BUTTON_MAP, buttonMap);
    }

}
