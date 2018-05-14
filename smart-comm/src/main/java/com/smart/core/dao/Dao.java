package com.smart.core.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ：崔
 * @commons.core.dao
 * @Description:Dao接口
 */
public interface Dao<T , ID extends Serializable> {



    T get(ID pk);
    int insert(T t);
    int update(T t);
    int remove(ID pk);
    int batchRemove(Long[] ids);
    List<T> condition(Map<String, Object>  map);
}