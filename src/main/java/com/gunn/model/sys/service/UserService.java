package com.gunn.model.sys.service;

import com.gunn.model.sys.dao.UserMapper;
import com.gunn.model.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int insertUser(User user){
        return userMapper.insertSelective(user);
    }

    public User login(String account, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("account", account);
        map.put("password", password);
        User user = userMapper.login(map);
        return user;
    }
}
