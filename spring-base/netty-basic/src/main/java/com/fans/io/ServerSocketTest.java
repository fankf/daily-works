package com.fans.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author fans
 * @date 2022/5/20 17:36
 * @description
 */
public class ServerSocketTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("====>>> 开始");
        Socket accept = serverSocket.accept();
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = accept.getInputStream();
        int len;
        byte[] bytes = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }
        System.out.println("get message from client:" + sb);
        // 关闭流
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
