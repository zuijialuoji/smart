package com.smart.service.impl;

import com.smart.core.service.Impl.ServiceImpl;
import com.smart.dao.sso.MenuDao;
import com.smart.domain.sys.Menu;
import com.smart.service.MenuService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Log
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu, Long> implements MenuService {

    @Autowired
    public void setDao(MenuDao dao) {
        this.dao = dao;
    }
}
