package com.smart.service.Impl;

import com.smart.core.service.Impl.ServiceImpl;
import com.smart.dao.customer.CustomerDao;
import com.smart.dao.sso.RoleDao;
import com.smart.domain.customer.Customer;
import com.smart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 崔宗鲁 on 2018/5/21.
 *
 * @Description:
 */
@Service
public class CustomerServiceImpl  extends ServiceImpl<CustomerDao, Customer, Long> implements CustomerService {

    @Autowired
    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }
    @Override
    public Customer findBYCustomerName(String customerName) {
        return dao.findBYCustomerName(customerName);
    }
}
