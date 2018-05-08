package com.smart.core.service;

import com.smart.core.domin.PersistentObject;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 崔宗鲁 on 2018/4/28.
 *
 * @Description:
 */
public interface Service <T extends PersistentObject,ID extends Serializable>{
    T get(ID pk);
    int save(T t);
    int update(T t);
    int remove(T t);
    int batchRemove(Long[] ids);
    List<T> condition(Map map);

}