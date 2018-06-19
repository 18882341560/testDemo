package com.gelin.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author green
 * @date 2018/5/15/015
 */
@Controller
@RequestMapping("/wsc")
public class WsController {

    @MessageMapping("/welcome")//1
    @SendTo("/topic/getResponse")//2
    public WiselyResponse say(WiselyMessage message) throws Exception {
        return new WiselyResponse("Welcome, " + message.getName() + "!");
    }

    @RequestMapping("/aaa")
    public String aaa(){
        return "websocket";
    }

}
