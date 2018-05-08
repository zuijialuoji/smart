package com.smart.controller;

import lombok.extern.java.Log;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@RestController
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
