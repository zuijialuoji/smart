package com.smart.controller;

import com.smart.domain.sys.Menu;
import com.smart.service.MenuService;
import com.smart.utils.Tree;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Log
@Controller
public class LoginController {


    @Autowired
    MenuService menuService;


    @GetMapping({ "/", "" })
    String welcome(Model model) {

        return "redirect:/blog";
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


    @GetMapping("/main")
    String main() {
        return "main";
    }
}
