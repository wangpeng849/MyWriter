/**
 * 
 */
package com.wangp.myaop.socket;
 
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
/**
 *************************************************************** 
 * 项目名称：JavaThread
 * 程序名称：MultiJabberServer
 * 日期：2012-8-23 下午02:38:20
 * 作者：
 * 模块：
 * 描述：
 * 备注：
 * ------------------------------------------------------------
 * 修改历史
 * 序号  				日期        		修改人       修改原因
 * 
 * 修改备注：
 * @version 
 ***************************************************************
 */
public class MultiJabberServer {
 
	
	/**
	 * 方法名：main
	 * 描述：
	 * 作者：
	 * 日期：2012-8-23 下午02:38:20
	 * @param @param args
	 * @return void
	 */
	public static void main(String[] args) {
		ServerSocket s = null;
		Socket socket  = null;
		try {
			s = new ServerSocket(8080);
			//等待新请求、否则一直阻塞
			while(true){
				socket = s.accept();
				System.out.println("socket:"+socket);
				new ServeOneJabbr(socket);
				
			}
		} catch (Exception e) {
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			try {
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
 
	}
 
}