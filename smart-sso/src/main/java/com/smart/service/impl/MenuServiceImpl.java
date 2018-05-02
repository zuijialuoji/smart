package com.smart.service.impl;

import com.smart.core.service.Impl.ServiceImpl;
import com.smart.dao.MenuDao;
import com.smart.domain.sys.Menu;
import com.smart.service.MenuService;
import lombok.extern.log4j.Log4j;

@Log4j
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu, Long> implements MenuService {
}
