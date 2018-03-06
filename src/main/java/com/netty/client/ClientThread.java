package com.netty.client;


import java.util.Scanner;

import org.jboss.netty.channel.Channel;
/**
 * 客户端线程
 * Created by dys on 2018/1/26.
 */
public class ClientThread extends Thread {
    private NettyClient nettyClient;

    private Scanner scanner = new Scanner(System.in);

    public void init() {
        nettyClient.init();
        nettyClient.start();
    }

    public void run() {
        while(true) {

            Channel channel = nettyClient.getChannelFuture().getChannel();
            System.out.println("发送消息（Enter发送）:");
            Object msg = scanner.next();
            if(msg.toString().equals("quit")) {
                System.out.println("wait, you will quit..");
                nettyClient.stop();

            }
            channel.write(msg);
        }
    }

    public void setNettyClient(NettyClient nettyClient) {
        this.nettyClient = nettyClient;
    }

}
