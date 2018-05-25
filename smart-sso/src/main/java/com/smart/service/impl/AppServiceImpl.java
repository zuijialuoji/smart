package com.smart.service.impl;

import com.smart.core.service.Impl.ServiceImpl;
import com.smart.dao.sso.AppDao;
import com.smart.domain.sys.App;
import com.smart.service.AppService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Log
@Service
public class AppServiceImpl extends ServiceImpl<AppDao, App, Long> implements AppService {

    @Autowired
    public void setDao(AppDao dao) {
        this.dao = dao;
    }


}
