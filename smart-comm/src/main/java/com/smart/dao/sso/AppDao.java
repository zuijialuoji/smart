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

}
