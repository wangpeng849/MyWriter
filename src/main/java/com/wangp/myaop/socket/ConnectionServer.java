package com.wangp.myaop.socket;

import lombok.Builder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionServer extends Thread {

    ServerSocket serverSocket = null;
    Socket socket = null;

    public ConnectionServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        System.out.println("wati client connection .....");

        try {
            socket = serverSocket.accept();
            //连接返回socket,在启动发送消息线程
            new SendMessThead().start();
            System.out.println(socket.getInetAddress().getHostAddress() + " SUCCESSFUL CONNECTION...");
            //获取输入流
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //读取数据
            String info = "";
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("client says:" + info);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class SendMessThead extends Thread {
        @Override
        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String info = "";
                do {
                    info = bufferedReader.readLine();
                    bufferedWriter.write("server say:" + info);
                    bufferedWriter.write("\n");
                    bufferedWriter.flush();
                } while (!"exit".equals(info));
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception e) {

                }
            }
//            super.run();
//            Scanner scanner=null;
//            OutputStream out = null;
//            try{
//                if(socket != null){
//                    scanner = new Scanner(System.in);
//                    out = socket.getOutputStream();
//                    String in = "";
//                    do {
//                        in = scanner.next();
//                        out.write(("server saying: "+in).getBytes());
//                        out.write("\n".getBytes());
//                        out.flush();//清空缓存区的内容
//                    }while (!in.equals("q"));
//                    scanner.close();
//                    try{
//                        out.close();
//                    }catch (IOException e){
//                        e.printStackTrace();
//                    }
//                }
//            }catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    public static void main(String[] args) throws IOException {
        ConnectionServer server = new ConnectionServer(1234);
        server.start();
    }
}
