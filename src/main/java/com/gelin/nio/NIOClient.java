package com.gelin.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by 葛林 on 2017/9/6.
 */
public class NIOClient {


    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8765);
        SocketChannel sc = null;
        ByteBuffer bb = ByteBuffer.allocate(1024);
        try {
            sc = SocketChannel.open();
            //进行连接
            sc.connect(address);

            while (true) {
                byte[] bytes = new byte[1024];
                System.in.read(bytes);
                bb.put(bytes);
                bb.flip();
                sc.write(bb);
                bb.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                try {
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
