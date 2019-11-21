package com.wangp.myaop.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        //等待客户端连接
        Socket socket = serverSocket.accept();
        //获取输入流
        InputStream inputStream = socket.getInputStream();
        //封装输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //读取数据
        String info = null;
        while ((info = bufferedReader.readLine())!=null) {
            System.out.println("客户端说:"+info);
        }
        //输出打印
//        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//        printWriter.write(info);
//        socket.shutdownOutput();
    }
}
