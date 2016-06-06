package com.lx.test.service.impl;

import com.lx.test.model.mybatis.User;
import com.lx.test.repository.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lx199 on 2016/6/3.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User get(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

}
