package com.smart.contorller;

import com.smart.domain.sys.Menu;
import com.smart.utils.Tree;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by 崔宗鲁 on 2018/5/22.
 *
 * @Description:
 */
@Log
@Controller
public class LoginController {




    @GetMapping({ "/", "" })
    String welcome(Model model) {

        return "redirect:/blog";
    }
    @GetMapping({ "/index" })
    String index(Model model) {
        long id =1;
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


