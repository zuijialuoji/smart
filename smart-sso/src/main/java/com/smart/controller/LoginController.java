package com.smart.controller;

import com.smart.comm.password.MD5Provider;
import com.smart.comm.session.SessionUtils;
import com.smart.core.domin.R;
import com.smart.domain.sys.Menu;
import com.smart.service.MenuService;
import com.smart.service.PermissionService;
import com.smart.service.UserService;
import com.smart.utils.Tree;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.ipc.netty.http.server.HttpServerRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Log
@Controller
public class LoginController {


    @Autowired
   private MenuService menuService;

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    @Value("1")
    private String appCode;


    @GetMapping({ "/", "" })
    String welcome(Model model) {

        return "redirect:/login";
    }
    @GetMapping({ "/index" })
    String index(Model model) {
        long id =1;
        List<Tree<Menu>> menus = menuService.listMenuTree(id);
        model.addAttribute("menus", menus);


        return "index_v1";
    }
    @GetMapping("/login")
    String login() {
        return "login";
    }



    @PostMapping("/login")
    @ResponseBody
    R ajaxLogin(String username, String password, HttpServletRequest request) {
       if(userService.checkPassword(username,password,request)){
           Long roleId =permissionService.getAppRole(SessionUtils.getSessionId(request),appCode);
           Set<String> permissionSet =permissionService.roleUrl(roleId);
           Map<String, List<String>> buttonMap =permissionService.buttonMap(roleId);
           SessionUtils.setPermissionSet(request,permissionSet);
           SessionUtils.setButtonMap(request,buttonMap);
           return R.ok();
       }
            return R.error("用户或密码错误");
    }
    @GetMapping("/main")
    String main() {
        return "main";
    }
}
