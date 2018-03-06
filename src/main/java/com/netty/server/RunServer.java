package com.netty.server;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
/**
 * server启动程序
 * Created by dys on 2018/1/26.
 */

public class RunServer {

    public static void main(String[] args) {

        String contextFile = "src/main/java/config/spring-server.xml";

        ApplicationContext context = null;
        try {
            context = new FileSystemXmlApplicationContext(contextFile);
        } catch (Exception e) {
            System.out.println("RunServer has some exception");
            e.printStackTrace();
        }
        final NettyServer server =(NettyServer)context.getBean("nettyServer");

        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                try {
                    server.stop();
                } catch (Exception e) {
                    System.out.println("run main stop error!");
                }
            }

        }  );
        server.init();
        server.start();
    }

}
