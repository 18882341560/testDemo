package com.gelin.controller;

import com.alibaba.fastjson.JSON;
import com.gelin.util.RtMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author green
 * @date 2018/6/19/019
 */
@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/t1")
    @ResponseBody
    public String test(){
        RtMsg rtMsg = RtMsg.INSTANCE;
        rtMsg.setSuccess(true);
        rtMsg.setMsg("十分士大夫");
        return rtMsg.toString();
    }

}
