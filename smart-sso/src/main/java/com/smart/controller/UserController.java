package com.smart.controller;

import com.smart.config.PageUtils;
import com.smart.config.Pagination;
import com.smart.config.Query;
import com.smart.core.domin.R;
import com.smart.domain.sys.Role;
import com.smart.domain.sys.User;
import com.smart.service.DictService;
import com.smart.service.RoleService;
import com.smart.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Log
@Controller
@RequestMapping("/user")
public class UserController {



    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    DictService dictService;

    private String prefix="system/user"  ;

    @GetMapping("")
    String user(Model model) {
        return prefix + "/user";
    }


    @GetMapping("/list")
    @ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据

        Pagination<User> query = new Pagination<User>(params);
        List<User> sysUserList = userService.condition(query);
        int total =(int)query.getRowCount();
        PageUtils pageUtil = new PageUtils(sysUserList, total);
        return pageUtil;
    }




    @GetMapping("/add")
    String add(Model model) {
        List<Role> roles = roleService.condition(new HashMap());
        model.addAttribute("roles", roles);
        return prefix + "/add";
    }



    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable("id") Long id) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        List<Role> roles = roleService.list(id);
        model.addAttribute("roles", roles);
        return prefix+"/edit";
    }



    @PostMapping("/save")
    @ResponseBody
    R save(User user) {
    /*    if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
       /* user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));*/
        if (userService.save(user) > 0) {
            return R.ok();
        }
        return R.error();
    }




    @PostMapping("/update")
    @ResponseBody
    R update(User user) {
 /*       if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        if (userService.update(user) > 0) {
            return R.ok();
        }
        return R.error();
    }




/* @PostMapping("/updatePeronal")
    @ResponseBody
    R updatePeronal(User user) {
      *//**//*  if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*//**//*
        if (userService.updatePersonal(user) > 0) {
            return R.ok();
        }
        return R.error();
    }*/

  /*
    @PostMapping("/remove")
    @ResponseBody
    R remove(Long id) {
    *//*    if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*//*
        if (userService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }



    @PostMapping("/batchRemove")
    @ResponseBody
    R batchRemove(@RequestParam("ids[]") Long[] userIds) {
      *//*  if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*//*
        int r = userService.batchremove(userIds);
        if (r > 0) {
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("/exit")
    @ResponseBody
    boolean exit(@RequestParam Map<String, Object> params) {
        // 存在，不通过，false
        return !userService.exit(params);
    }



*/










}
