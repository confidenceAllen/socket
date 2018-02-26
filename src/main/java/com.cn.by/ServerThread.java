package com.cn.by;


import java.io.*;
import java.net.Socket;

/**
* @author By
* @date 2018/2/26 21:12
* @description  服务器线程处理类
* @return
*/
public class ServerThread extends Thread{

    Socket socket = null;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            //3.实现数据的交互，读取客户端信息
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine())!=null){
                System.out.println("我是服务器，客户端的信息是："+info);
            }
            socket.shutdownInput();

            //4.获取输出流，响应客户端
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("你好啊。欢迎你");

            //5.关闭资源
            pw.close();
            os.close();

            is.close();
            isr.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
