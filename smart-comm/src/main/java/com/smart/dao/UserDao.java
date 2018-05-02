package com.smart.dao;

import com.smart.core.dao.Dao;
import com.smart.domain.sys.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao extends Dao<User, Long> {
}
