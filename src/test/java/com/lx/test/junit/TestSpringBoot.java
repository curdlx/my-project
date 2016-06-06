package com.lx.test.junit;

import com.lx.test.SpringBootRun;
import com.lx.test.model.mybatis.User;
import com.lx.test.repository.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lx199 on 2016/6/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootRun.class)
public class TestSpringBoot{

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        User user = userMapper.selectByPrimaryKey(1);
        Assert.assertNotNull(user);

    }

    @Test
    public void test2(){
        User user = new User(2,"shengjuan",26,1,366.66f);
        userMapper.insert(user);
    }


}
