package com.smart.service.Impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.smart.dao.customer.CustomerDao;
import com.smart.domain.customer.Customer;
import com.smart.service.CustomerService;
import org.springframework.stereotype.Service;

/**
 * Created by 崔宗鲁 on 2018/5/11.
 *
 * @Description:
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerDao, Customer> implements CustomerService {


    @Override
    public Customer findBYCustomerName(String customerName) {
        return baseMapper.findBYCustomerName(customerName);
    }
}
