package com.smart.dao.sso;

import com.smart.core.dao.Dao;
import com.smart.domain.sys.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface MenuDao extends Dao<Menu, Long> {

    List<Menu> listMenuByUserId(Long id);
}
