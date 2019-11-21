package com.wangp.myaop.socket;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream ops = null;
        PrintWriter pw = null;

        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            String info = null;

            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器，我说：" + info);
            }
            socket.close();

            ops = socket.getOutputStream();
            pw = new PrintWriter(ops);
            pw.write("服务器欢迎你！");
            pw.flush();
        } catch (IOException e) {

        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
                if (ops != null) {
                    ops.close();
                }
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (is != null) {
                    is.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {

            }

        }
    }
}
