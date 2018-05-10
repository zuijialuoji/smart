package com.smart.service.impl;

import com.smart.core.service.Impl.ServiceImpl;
import com.smart.dao.comm.DictDao;
import com.smart.domain.comm.Dict;
import com.smart.service.DictService;
import org.springframework.stereotype.Service;

/**
 * Created by 崔宗鲁 on 2018/5/9.
 *
 * @Description:
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictDao, Dict, Long> implements DictService {
}
