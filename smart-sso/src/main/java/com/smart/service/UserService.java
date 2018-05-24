package com.smart.service;

import com.smart.core.service.Service;
import com.smart.domain.sys.User;

import java.util.Map;

public interface UserService   extends Service<User, Long> {

    int updatePersonal(User user);

    boolean exit(Map<String, Object> params);
}
