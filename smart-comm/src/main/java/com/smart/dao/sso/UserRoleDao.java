package com.smart.dao.sso;

import com.smart.core.dao.Dao;
import com.smart.domain.sys.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 崔宗鲁 on 2018/5/11.
 *
 * @Description:
 */
@Mapper
@Repository
public interface UserRoleDao extends Dao<UserRole, Long> {

    List<Long> listRoleId(Long userId);

    @Select(value = "select role_id from user_role where user_id = #{arg0} and app_code=#{arg1}")
    UserRole getAppRole(Long userId, String appCode);
}
