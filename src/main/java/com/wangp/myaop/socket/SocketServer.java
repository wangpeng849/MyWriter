package com.wangp.myaop.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        //创建服务器
        ServerSocket serverSocket = new ServerSocket(8000);
        //创建客户端连接
        Socket socket = new Socket();
        //循环监听
        while(true){
            //监听客户端
            socket = serverSocket.accept();
            ServerThread thread = new ServerThread(socket);
            thread.start();

            InetAddress address = socket.getInetAddress();
            System.out.println("当前客户顿iP："+address.getHostAddress());
        }
    }
}

