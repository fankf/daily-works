package com.fans.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author fans
 * @date 2022/5/20 17:19
 * @description
 */
public class SocketTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",12345);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,world!".getBytes(StandardCharsets.UTF_8));

        outputStream.close();
        socket.close();
    }
}
