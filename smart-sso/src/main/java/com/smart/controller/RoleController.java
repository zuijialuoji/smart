package com.smart.controller;


import com.smart.core.domin.R;
import com.smart.domain.sys.Role;
import com.smart.service.RoleService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Log
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    String prefix = "system/role";

    @GetMapping()
    String role() {
        return prefix + "/role";
    }


    @GetMapping("/list")
    @ResponseBody()
    List<Role> list() {
        List<Role> roles = roleService.condition(new HashMap<>(16));
        return roles;
    }



    @GetMapping("/add")
    String add() {
        return prefix + "/add";
    }


    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        Role role = roleService.get(id);
        List<Long> menus = roleService.getRoleMenu(id);
        role.setMenuIds(menus);
        model.addAttribute("role", role);
        return prefix + "/edit";
    }


    @PostMapping("/save")
    @ResponseBody()
    R save(Role role) {
    /*    if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        if (roleService.save(role) > 0) {
            return R.ok();
        } else {
            return R.error(1, "保存失败");
        }
    }


    @PostMapping("/update")
    @ResponseBody()
    R update(Role role) {
      /*  if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        if (roleService.update(role) > 0) {
            return R.ok();
        } else {
            return R.error(1, "保存失败");
        }
    }


    @PostMapping("/remove")
    @ResponseBody()
    R save(Long id) {
/*        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        if (roleService.remove(id) > 0) {
            return R.ok();
        } else {
            return R.error(1, "删除失败");
        }
    }

    /*@RequiresPermissions("sys:role:batchRemove")
    @Log("批量删除角色")*/
    @PostMapping("/batchRemove")
    @ResponseBody
    R batchRemove(@RequestParam("ids[]") Long[] ids) {
   /*     if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        int r = roleService.batchRemove(ids);
        if (r > 0) {
            return R.ok();
        }
        return R.error();
    }


}
