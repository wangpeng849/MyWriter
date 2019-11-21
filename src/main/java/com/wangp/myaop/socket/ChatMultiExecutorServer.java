package com.wangp.myaop.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newFixedThreadPool;


public class ChatMultiExecutorServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        ExecutorService executorService = newFixedThreadPool(100);
        while (true) {
            //等待客户端连接
            Socket socket = serverSocket.accept();
            Runnable runnable = () -> {
                //获取输入流
                InputStream inputStream = null;
                try {
                    inputStream = socket.getInputStream();
                    //封装输入流
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    //读取数据
                    String info = null;
                    while ((info = bufferedReader.readLine()) != null) {
                        System.out.println("客户端说:" + info);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            executorService.submit(runnable);
        }
        //输出打印
//        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//        printWriter.write(info);
//        socket.shutdownOutput();
    }
}
