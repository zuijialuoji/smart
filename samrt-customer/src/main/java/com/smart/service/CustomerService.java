package com.smart.service;

import com.smart.core.service.Service;
import com.smart.domain.customer.Customer;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 崔宗鲁 on 2018/5/21.
 *
 * @Description:
 */
public interface CustomerService extends Service<Customer, Long> {

    Customer findBYCustomerName(String customerName);
}
