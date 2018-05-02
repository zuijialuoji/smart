package com.smart.service.impl;

import com.smart.core.service.Impl.ServiceImpl;
import com.smart.dao.UserDao;
import com.smart.domain.sys.User;
import com.smart.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Log4j
public class UserServiceImpl extends ServiceImpl<UserDao, User, Long> implements UserService {

    @Resource
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public User get(Long pk) {
        return null;
    }

    @Override
    public int save(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public List<User> condition(Map map) {
        return null;
    }

    @Override
    public List<User> queryAll() {
        return null;
    }


    public void deleteById(Integer integer) {

    }
}
