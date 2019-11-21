package com.wangp.myaop.socket;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        //和服务器连接
        Socket socket = new Socket("localhost", 8000);

        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        while (true) {
            //发送消息
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("来自客户端的消息....");
            printWriter.flush();

//            socket.shutdownOutput();

            //接受的消息
            inputStream = socket.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String info = bufferedReader.readLine();
            System.out.println("收到消息：" + info);
            if("bye".equals(info)){
                break;
            }
        }

        bufferedReader.close();
        inputStream.close();
        printWriter.close();
        outputStream.close();
        socket.close();

    }
}

