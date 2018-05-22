package com.smart.dao.customer;


import com.smart.core.dao.Dao;
import com.smart.domain.customer.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by 崔宗鲁 on 2018/5/8.
 *
 * @Description:
 */
@Mapper
@Repository
public interface CustomerDao extends Dao<Customer, Long> {
    @Select("select * from cus_customer where customer_name =#{customerName}")
    Customer findBYCustomerName(String customerName);
}
