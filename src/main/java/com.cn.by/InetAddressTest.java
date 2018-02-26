package com.cn.by;

import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;


/**
* @author By
* @date 2018/2/22 22:02
* @description  socket 课程第一节
* @return
*/
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("计算机名称："+inetAddress.getHostName());
        System.out.println("计算机地址："+inetAddress.getHostAddress());
        byte[] bytes = inetAddress.getAddress();
        System.out.println("字节数组："+ Arrays.toString(bytes));
        System.out.println("直接输出InetAddress："+inetAddress);


    }
}
