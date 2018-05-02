package com.smart.core.service.Impl;

import com.smart.core.dao.Dao;
import com.smart.core.domin.PersistentObject;
import com.smart.core.service.Service;
import lombok.extern.log4j.Log4j;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @param <DAO>
 * @param <T>
 * @param <ID>
 * @author ：崔
 * @commons.core.service.impl
 * @Description:  Service基类，实现了数据的CRUD
 */

public  class ServiceImpl<DAO extends Dao<T, ID>, T extends PersistentObject, ID extends Serializable>
        implements Service<T, ID> {

    protected DAO dao;

    @Override
    public T get(ID pk) {
        return null;
    }

    @Override
    public int save(T t) {
        return 0;
    }

    @Override
    public int update(T t) {
        return 0;
    }

    @Override
    public void deleteById(ID id) {

    }

    @Override
    public List<T> condition(Map map) {
        return null;
    }

    @Override
    public List<T> queryAll() {
        return null;
    }
}
