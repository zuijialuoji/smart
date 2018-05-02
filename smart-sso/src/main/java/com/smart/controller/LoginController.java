package com.smart.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Log4j
@Controller
public class LoginController {

    @GetMapping({ "/", "" })
    String welcome(Model model) {

        return "redirect:/blog";
    }
    @GetMapping({ "/index" })
    String index(Model model) {

        return "index_v1";
    }
    @GetMapping("/login")
    String login() {
        return "login";
    }
}
