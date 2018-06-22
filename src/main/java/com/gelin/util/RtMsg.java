package com.gelin.util;

/**
 * 接口返回类型，layui框架分页不用这个
 */
import java.util.HashMap;
import java.util.Map;

public enum  RtMsg {
    INSTANCE;
    private boolean success;
    private String msg;
    private Map<String, Object> datas = new HashMap<String, Object>();
    private Integer status = 0;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getDatas() {
        return datas;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RtMsgUtil{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", datas=" + datas +
                ", status=" + status +
                '}';
    }
}

