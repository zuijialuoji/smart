package com.smart.dao.sso;

import com.smart.core.dao.Dao;
import com.smart.domain.sys.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface DeptDao extends Dao<Dept, Long> {

    int getDeptUserNumber(Long deptId);

    int count(Map<String, Object> map);
}
