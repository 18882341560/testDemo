package com.gelin.util;

import java.util.UUID;

/**
 * Created by 葛林 on 2017/7/23.
 */
public class UUIDutils {

    //随机生成32位字符串
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
