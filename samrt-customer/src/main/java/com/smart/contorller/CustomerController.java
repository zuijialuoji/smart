package com.smart.contorller;

import com.smart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by 崔宗鲁 on 2018/5/21.
 *
 * @Description:
 */
public class CustomerController {



    @Autowired
    private CustomerService customerService;


    private String prefix = "cus/customer";

    @GetMapping()
    String customer() {
        return prefix + "/customer";
    }














}
