package com.smart.service.impl;

import com.smart.core.service.Impl.ServiceImpl;
import com.smart.dao.DeptDao;
import com.smart.domain.sys.Dept;
import com.smart.service.DeptService;
import lombok.extern.log4j.Log4j;

@Log4j
public class DeptServiceImpl extends ServiceImpl<DeptDao, Dept, Long> implements DeptService {
}
