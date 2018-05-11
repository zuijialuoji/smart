package com.smart.dao.sso;

import com.smart.core.dao.Dao;
import com.smart.domain.sys.App;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Mapper
@Repository
public interface AppDao extends Dao<App, Long> {
    int enable(@Param("isEnable") Boolean isEnable, @Param("idList") List<Integer> idList);

     App findByCode(@Param("code") String code);

     List<App> findByUserId(@Param("isEnable") Boolean isEnable, @Param("userId") Integer userId);

     Set<String> findAppCodeByUserId(@Param("isEnable") Boolean isEnable, @Param("userId") Integer userId);
}
