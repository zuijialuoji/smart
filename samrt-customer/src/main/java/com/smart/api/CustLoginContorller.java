package com.smart.api;

import com.smart.comm.password.MD5Provider;
import com.smart.core.domin.Result;
import com.smart.core.domin.ResultCode;
import com.smart.domain.customer.Customer;
import com.smart.service.CustomerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 崔宗鲁 on 2018/5/15.
 *
 * @Description:
 */
@RestController
@RequestMapping("/cus")
public class CustLoginContorller {



    @Autowired
    private CustomerService customerService;



    @ApiOperation(value = "客户账号密码登录", notes = "客户根据用户名登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerNmae", value = "用户登录名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "客户密码", required = true, dataType = "String")
    })
    @PostMapping("/cus-login")
    public Result CusLogin(String customerNmae , String password){
        Customer customer =customerService.findBYCustomerName(customerNmae);
        if(customer.getPassword().equals(MD5Provider.encrypt(password))){
            return Result.createSuccessResult(customer, "登录成功！");
        }
        return Result.create(ResultCode.ERROR).setMessage("密码错误");

    }


    @ApiOperation(value = "客户邮箱密码登录", notes = "客户根据邮箱登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "用户邮箱", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "客户密码", required = true, dataType = "String")
    })
    @PostMapping("/cus-login-email")
    public Result CusLoginEmail(String email , String password){
        return Result.createSuccessResult(null, "登录成功！");
    }


    @ApiOperation(value = "客户电话验证码登录", notes = "客户根据电话号登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "iphone", value = "用户电话号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "客户密码", required = true, dataType = "String")
    })
    @PostMapping("/cus-login-iphone")
    public Result CusLoginIphone(String iphone , String password){
        return Result.createSuccessResult(null, "登录成功！");
    }


    @ApiOperation(value = "客户注册", notes = "客户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "customer", value = "用户详细实体customer", required = true, dataType = "Customer")
    })
    @PostMapping("/register")
    public Result register(Customer customer){
        customerService.save(customer);
        return Result.createSuccessResult(null, "注册成功！");
    }















    
}
