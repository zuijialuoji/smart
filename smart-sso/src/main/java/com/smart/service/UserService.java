package com.smart.service;

import com.smart.core.service.Service;
import com.smart.domain.sys.User;


import javax.servlet.http.HttpServletRequest;


import java.util.Map;

public interface UserService   extends Service<User, Long> {

    int updatePersonal(User user);

    boolean exit(Map<String, Object> params);

    boolean checkPassword(String username ,String password,HttpServletRequest request);
}
