package com.gelin.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 葛林 on 2017/9/6.
 */
public class Server {


    //缓存池
    private ExecutorService executorService;

    //线程组
    private AsynchronousChannelGroup acg;

    //服务器通道
    public AsynchronousServerSocketChannel assc;

    public Server(int port) {
        //创建一个缓存池
        executorService = Executors.newCachedThreadPool();
        try {
            //创建线程组
            acg = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
            //创建服务器通道
            assc = AsynchronousServerSocketChannel.open(acg);
            assc.bind(new InetSocketAddress(port));
            System.out.println("server start port:" + port);
            //进行阻塞
            assc.accept(this, new ServerCompletionHandler());
            //一直阻塞，不让服务器停止
            Thread.sleep(Integer.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server(8765);
    }


}
