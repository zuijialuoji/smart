package com.smart.controller;

import com.smart.domain.sys.Menu;
import com.smart.service.MenuService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
        Map map = new HashMap();
        List<Menu> menus = menuService.condition(map);
        return menus;
    }
    @GetMapping("/get")
    @ResponseBody
    Menu findOne() {
        Menu m  = menuService.get((long)1);
        return m;
    }
}
