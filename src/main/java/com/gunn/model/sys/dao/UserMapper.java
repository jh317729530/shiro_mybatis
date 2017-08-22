package com.gunn.model.sys.dao;

import com.gunn.model.sys.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    //////////////////////////////////////////////////////

    User login(Map<String, Object> map);
}