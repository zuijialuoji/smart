package com.smart.dao.customer;

import com.smart.base.myplus.SuperMapper;
import com.smart.domain.customer.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by 崔宗鲁 on 2018/5/15.
 *
 * @Description:
 */
@Mapper
public interface CustomerDao extends SuperMapper<Customer> {
}
