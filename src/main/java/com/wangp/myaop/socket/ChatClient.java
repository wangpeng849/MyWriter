package com.wangp.myaop.socket;

import java.io.*;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) throws IOException {
        //连接服务端
        Socket socket = new Socket("localhost",9000);
        //写入
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String info = bufferedReader.readLine();
            bufferedWriter.write(info);
            bufferedWriter.write("\n");
            bufferedWriter.flush();
        }

//        bufferedWriter.write("hello Server,I am client!");
    }
}
