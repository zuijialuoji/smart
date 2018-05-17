package com.smart.service;

import com.baomidou.mybatisplus.service.IService;
import com.smart.domain.customer.Customer;

/**
 * Created by 崔宗鲁 on 2018/5/11.
 *
 * @Description:
 */
public interface CustomerService extends IService<Customer> {

    Customer findBYCustomerName(String customerName);
}
