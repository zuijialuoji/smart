package com.smart.service.impl;

import com.smart.core.service.Impl.ServiceImpl;
import com.smart.core.service.Service;
import com.smart.dao.AppDao;
import com.smart.domain.sys.App;
import com.smart.service.AppService;
import lombok.extern.log4j.Log4j;

import java.util.List;
import java.util.Map;

@Log4j
public class AppServiceImpl extends ServiceImpl<AppDao, App, Long> implements AppService {



    @Override
    public App get(Long pk) {
        return null;
    }

    @Override
    public int save(App app) {
        return 0;
    }

    @Override
    public int update(App app) {
        return 0;
    }

    @Override
    public List<App> condition(Map map) {
        return null;
    }

    @Override
    public List<App> queryAll() {
        return null;
    }


    public void deleteById(Integer integer) {

    }
}
