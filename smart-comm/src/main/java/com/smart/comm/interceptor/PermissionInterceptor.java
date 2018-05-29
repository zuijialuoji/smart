package com.smart.comm.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.smart.comm.session.SessionUtils;
import com.smart.core.domin.Result;
import com.smart.core.domin.ResultCode;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * Created by 崔宗鲁 on 2018/5/26.
 *
 * @Description:
 */
public class PermissionInterceptor  implements HandlerInterceptor {


    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView arg3)
            throws Exception {




    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object obj) throws Exception {
        // 跨域
        request.setCharacterEncoding("utf-8");
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession(false);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.addHeader("Access-Control-Max-Age", "100");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type");
        response.addHeader("Access-Control-Allow-Credentials", "false");


        if(requestURI.indexOf("login")>0||requestURI.indexOf("login_out")>0){
            return true;
        }

        if(session ==null){
/*            Result result =Result.create(ResultCode.VALIDATE_ERROR).setMessage("请先登陆！");
            response.getWriter().write(JSONObject.fromObject(result).toString());*/
            return false;
        }
        boolean isPermitted = isPermitted(request ,requestURI);
        if(isPermitted == false){
    /*        Result result =Result.create(ResultCode.VALIDATE_ERROR).setMessage("权限不足请申请权限！");
            response.getWriter().write(JSONObject.fromObject(result).toString());*/
        }
        return  true;
    }



    private boolean isPermitted(HttpServletRequest request, String path) {
        Set<String> permissionSet = SessionUtils.getPermissionSet(request);
        if(permissionSet.contains(path)){
            return true;
        }
        return false;
    }

}

