package com.smart.controller;


import com.smart.domain.sys.Role;
import com.smart.service.RoleService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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


    @GetMapping("/getOne")
    public Role findOne(){
        Long l = new Long(1);
        Role r =roleService.get(l);
        return  r;
    }



}
