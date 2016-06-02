package com.lx.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

/**
 * Created by lx199 on 2016/5/12.
 */
@Controller
public class SpringBootController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "hello word";
    }

}
