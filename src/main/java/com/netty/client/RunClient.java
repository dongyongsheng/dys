package com.netty.client;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 客户端启动程序
 * Created by dys on 2018/1/29.
 */
public class RunClient {

    public static void main(String[] args) {

        String contextFile = "src/main/java/config/spring-client.xml";

        ApplicationContext context = null;
        try {
            context = new FileSystemXmlApplicationContext(contextFile);
        } catch (Exception e) {
            System.out.println("RunMain has some exception");
            e.printStackTrace();
        }
        ClientThread client = (ClientThread)context.getBean("clientThread");

        client.init();
        client.start();
    }
}