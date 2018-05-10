package com.smart.dao.comm;

import com.smart.core.dao.Dao;
import com.smart.domain.comm.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by 崔宗鲁 on 2018/5/8.
 *
 * @Description:
 */
@Mapper
@Repository
public interface DictDao extends Dao<Dict, Long> {
}
