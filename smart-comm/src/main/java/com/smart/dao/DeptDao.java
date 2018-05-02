package com.smart.dao;

import com.smart.core.dao.Dao;
import com.smart.domain.sys.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DeptDao extends Dao<Dept, Long> {
}
