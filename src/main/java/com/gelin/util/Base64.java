package com.gelin.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by 葛林 on 2017/7/20.
 */
public class Base64 {

    private static String src = "葛林你好帅";

    public static void main(String[] args) {
        //jdkBase64();
        //commonsCodecBase64();
        bouncyCastlebase64();
    }


    //jdk提供的
    public static void jdkBase64() {
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            String encode = encoder.encode(src.getBytes());//加密
            System.out.println(encode);

            BASE64Decoder decoder = new BASE64Decoder();//解密
            System.out.println(new String(decoder.decodeBuffer(encode)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //commonsCodec
    public static void commonsCodecBase64() {
        byte[] encode = org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes());
        System.out.println(new String(encode));

        byte[] decode = org.apache.commons.codec.binary.Base64.decodeBase64(encode);
        System.out.println(new String(decode));
    }

    public static void bouncyCastlebase64() {
        byte[] b = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
        System.out.println(new String(b));

        byte[] b2 = org.bouncycastle.util.encoders.Base64.decode(b);
        System.out.println(new String(b2));
    }


}
