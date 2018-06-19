package com.gelin.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

import static com.sun.deploy.perf.DeployPerfUtil.write;

/**
 * Created by 葛林 on 2017/9/6.
 */
public class ServerCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, Server> {

    @Override//AsynchronousSocketChannel 客户端的通道
    public void completed(AsynchronousSocketChannel result, Server attachment) {
        //当有下一个客户端接入的时候，直接调用Server的accept方法，这样反复执行下去，保证多个客户端都可以阻塞
        attachment.assc.accept(attachment, this);
        read(result);
    }

    @Override
    public void failed(Throwable exc, Server attachment) {
        exc.printStackTrace();
    }

    public void read(AsynchronousSocketChannel asc) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        asc.read(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                //读取之后，重置标识位
                attachment.flip();
                //获得读取的字节数
                System.out.println("server 收到客户端的数据长度为:" + result);
                //获取读取的数据
                String data = new String(attachment.array()).trim();
                String response = "服务器响应，收到客户端发来的数据" + data;
                write(asc, response);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
            }
        });
    }


    public void write(AsynchronousSocketChannel asc, String resp) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(resp.getBytes());
        buffer.flip();
        try {
            asc.write(buffer).get();//asc.write(buffer) 返回一个Future对象，会新启一个线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
