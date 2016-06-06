package com.lx.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lx.test.model.mybatis.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lx199 on 2016/5/12.
 */
@RestController
public class SpringBootController implements Serializable{
    private static Map<Integer,User> map =null;
    static {
         map = new HashMap<Integer, User>();
        map.put(1,new User(1,"lixin",1,26,16.2f));
    }

    @RequestMapping("/test")
    public String test() throws JsonProcessingException {
//        map.put("hello","world");
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> list = new ArrayList<User>();
        list.add( map.get(1));
        list.add( map.get(1));
        String s = objectMapper.writeValueAsString(list);
        return s;
    }

}
