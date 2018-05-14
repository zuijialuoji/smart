package com.smart.core.service.Impl;

import com.smart.core.dao.Dao;
import com.smart.core.domin.PersistentObject;
import com.smart.core.service.Service;
import lombok.extern.java.Log;


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
@Log
public  class ServiceImpl<DAO extends Dao<T, ID>, T extends PersistentObject, ID extends Serializable>
        implements Service<T, ID> {

    protected DAO dao;

    @Override
    public T get(ID pk) {
        return dao.get(pk);
    }

    @Override
    public int save(T t) {
        return dao.insert(t);
    }

    @Override
    public int update(T t) {

        return dao.update(t);
    }

    @Override
    public int remove(ID pk) {

        return dao.remove(pk);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return dao.batchRemove(ids);
    }

    @Override
    public List<T> condition(Map<String, Object>  map) {
        return dao.condition(map);
    }


}
