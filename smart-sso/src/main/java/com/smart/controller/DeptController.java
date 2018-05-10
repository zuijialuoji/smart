package com.smart.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Log
@Controller
@RequestMapping("/dept")
public class DeptController {

    private String prefix = "system/dept";

    @GetMapping()
    String dept() {
        return prefix + "/dept";
    }
}
