package com.smart.controller;

import com.smart.service.DictService;
import com.smart.service.RoleService;
import com.smart.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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















}
