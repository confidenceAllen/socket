package com.cn.by;


import java.io.*;
import java.net.Socket;

/**
* @author By
* @date 2018/2/26 20:46
* @description 客户端
* @return
*/
public class Cilent {

    public static void main(String[] args) throws IOException {
        //1.创建客户端socket
        Socket socket = new Socket("localhost",8888);
        //2.获取输出流，用来向服务器发送信息
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("你好啊，socket！我叫张三");
        //刷新，向服务器发送信息
        pw.flush();
        socket.shutdownOutput();

        //3.获取输入流
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String info = null;
        while ((info = br.readLine())!=null){
            System.out.println("我是客户端，服务端的信息是："+info);
        }

        //4.关闭资源
        br.close();
        is.close();
        pw.close();
        os.close();
        socket.close();
    }
}
