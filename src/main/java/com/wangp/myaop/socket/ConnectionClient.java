package com.wangp.myaop.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionClient extends Thread {
    //socket 创建
    Socket socket = null;

    public ConnectionClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    @Override
    public void run() {
        //客户端连接
        new SendMessThead().start();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String info = "";
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println(info);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class SendMessThead extends Thread {
        @Override
        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String info = "";
                do {
                    info = bufferedReader.readLine();
                    bufferedWriter.write("" + info);
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
//            //写操作
//            Scanner scanner=null;
//            OutputStream os= null;
//            try {
//                scanner=new Scanner(System.in);
//                os= socket.getOutputStream();
//                String in="";
//                do {
//                    in=scanner.next();
//                    os.write((""+in).getBytes());
//                    os.write("\n".getBytes());
//                    os.flush();
//                } while (!in.equals("bye"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            scanner.close();
//            try {
//                os.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    public static void main(String[] args) throws IOException {
        ConnectionClient connectionClient = new ConnectionClient("127.0.0.1", 1234);
        connectionClient.start();
    }
}
