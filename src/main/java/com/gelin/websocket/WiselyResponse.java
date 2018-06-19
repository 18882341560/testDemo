package com.gelin.websocket;

/**
 * @author green
 * @date 2018/5/15/015
 */
public class WiselyResponse {
    private String responseMessage;

    public WiselyResponse(String responseMessage){
        this.responseMessage = responseMessage;
    }
    public String getResponseMessage(){
        return responseMessage;
    }

}
