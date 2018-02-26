package com.cn.by;


import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
* @author By
* @date 2018/2/26 20:47
* @description 客户端
* @return
*/
public class Server {

    public static void main(String[] args) throws IOException {
        //1.创建一个服务端
        ServerSocket serverSocket = new ServerSocket(8888);
        //记录数
        int count = 0;
        //2.调用accept()方法开始监听,等待客户端的连接
        Socket socket = null;
        System.out.println("**服务启动，等待客户端**");
        while (true){
            socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(socket);

            serverThread.start();
            count++;
            System.out.println("客户端的："+count);
            InetAddress address = socket.getInetAddress();
            System.out.println("当前的IP地址是:"+address.getHostAddress());
        }
    }
}
