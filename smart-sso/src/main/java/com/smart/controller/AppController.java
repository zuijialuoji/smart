package com.smart.controller;

import com.smart.core.domin.R;
import com.smart.domain.sys.App;
import com.smart.service.AppService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Log
@Controller
@RequestMapping(value = "/app")
public class AppController  {


    @Autowired
    private AppService appService;
    private String prefix = "system/app";

    @GetMapping()
    String dept() {
        return prefix + "/app";
    }

    @ResponseBody
    @GetMapping("/list")
    public List<App> list() {
        Map<String, Object> map = new HashMap<>(16);
        List<App> appList = appService.condition(map);
        return appList;
    }


    @GetMapping("/add/")
    String add( ) {
        return  prefix + "/add";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(App app) {
      /*  if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        if (appService.save(app) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        App app = appService.get(id);
        model.addAttribute("app", app);
        return  prefix + "/edit";
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(App app) {
      /*  if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        if (appService.update(app) > 0) {
            return R.ok();
        }
        return R.error();
    }




}
