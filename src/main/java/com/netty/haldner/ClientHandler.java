package com.netty.haldner;

/**
 * 先定义客户端handler，接收到服务器的消息，然后打印出来。
 * Created by dys on 2018/1/26.
 */

import java.util.Date;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class ClientHandler extends SimpleChannelHandler {

    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
        try{
            String content = (String) e.getMessage();
            System.out.println(""+ new Date().toString() + "\n" + content);
        }catch (Exception E){
            E.printStackTrace();
        }

    }
}
