package com.smart.controller;

import com.smart.core.domin.R;
import com.smart.domain.sys.Menu;
import com.smart.service.MenuService;
import com.smart.utils.Tree;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Log
@Controller
@RequestMapping("/menu")
public class MenuContorller {


    String prefix = "system/menu";

    @GetMapping()
    String menu(Model model) {
        return prefix+"/menu";
    }

    @Autowired
    MenuService menuService;





    @RequestMapping("/list")
    @ResponseBody
    List<Menu> list(@RequestParam Map<String, Object> params) {
        List<Menu> menus = menuService.condition(params);
        return menus;
    }


    @GetMapping("/add/{pId}")
    String add(Model model, @PathVariable("pId") Long pId) {
        model.addAttribute("pId", pId);
        if (pId == 0) {
            model.addAttribute("pName", "根目录");
        } else {
            model.addAttribute("pName", menuService.get(pId).getName());
        }
        return prefix + "/add";
    }



    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable("id") Long id) {
        Menu mdo = menuService.get(id);
        Long pId = mdo.getParentId();
        model.addAttribute("pId", pId);
        if (pId == 0) {
            model.addAttribute("pName", "根目录");
        } else {
            model.addAttribute("pName", menuService.get(pId).getName());
        }
        model.addAttribute("menu", mdo);
        return prefix+"/edit";
    }


    @PostMapping("/save")
    @ResponseBody
    R save(Menu menu) {
    /*    if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        if (menuService.save(menu) > 0) {
            return R.ok();
        } else {
            return R.error(1, "保存失败");
        }
    }


    @PostMapping("/update")
    @ResponseBody
    R update(Menu menu) {
    /*    if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        if (menuService.update(menu) > 0) {
            return R.ok();
        } else {
            return R.error(1, "更新失败");
        }
    }


    @PostMapping("/remove")
    @ResponseBody
    R remove(Long id) {
    /*    if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        if (menuService.remove(id) > 0) {
            return R.ok();
        } else {
            return R.error(1, "删除失败");
        }
    }

    @GetMapping("/tree")
    @ResponseBody
    Tree<Menu> tree() {
        Tree<Menu> tree = new Tree<Menu>();
        tree = menuService.getTree();
        return tree;
    }

    @GetMapping("/tree/{roleId}")
    @ResponseBody
    Tree<Menu> tree(@PathVariable("roleId") Long roleId) {
        Tree<Menu> tree = new Tree<Menu>();
        tree = menuService.getTree(roleId);
        return tree;
    }

}
