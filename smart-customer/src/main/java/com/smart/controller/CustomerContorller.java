package com.smart.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.smart.domain.customer.Customer;
import com.smart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 崔宗鲁 on 2018/5/11.
 *
 * @Description:
 */
@Controller
@RequestMapping("/customer")
public class CustomerContorller {

    @Autowired
    private CustomerService customerService;


    private String prefix = "cus/customer";

    @GetMapping()
    String role() {
        return prefix + "/customer";
    }

    /**
     * 7、分页 size 一页显示数量  current 当前页码
     * 方式一：http://localhost:8080/user/page?size=1&current=1<br>
     * 方式二：http://localhost:8080/user/pagehelper?size=1&current=1<br>
     */

    // 参数模式分页
    @GetMapping("/list")
    @ResponseBody
    public  Page<Customer> page(Page page) {
        return customerService.selectPage(page);
    }











}
