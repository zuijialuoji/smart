package com.smart.dao.sso;

import com.smart.core.dao.Dao;
import com.smart.domain.sys.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserDao extends Dao<User, Long> {
    /**
     *
     * @param username
     * @return  根据用户名获得用户信息
     */
    @Select(value = "select * from user where username =#{username}")
    User getUserName(String username);
}
