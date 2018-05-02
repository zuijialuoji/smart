package com.smart.dao;

import com.smart.core.dao.Dao;
import com.smart.domain.sys.App;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AppDao extends Dao<App, Long> {
}
