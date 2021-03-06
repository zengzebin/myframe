package SocketPaclages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) {

		/*
		 * for (int i = 0; i <10; i++) {
		 * 
		 * Thread t = new Thread() {
		 * 
		 * public void run() {
		 */
		try {

			// TODO Auto-generated method stub
			// 1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
			ServerSocket serverSocket = new ServerSocket(10086);
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 1024-65535的某个端口
				// 2、调用accept()方法开始监听，等待客户端的连接
				Socket socket = serverSocket.accept();
				// 3、获取输入流，并读取客户端信息
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String info = null;
				while ((info = br.readLine()) != null) {
					System.out.println("当前线程" + Thread.currentThread().getId());
					System.out.println("Hello,我是服务器，客户端说：" + info);
				}
				socket.shutdownInput();// 关闭输入流

				// 4、获取输出流，响应客户端的请求
				OutputStream os = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os);
				pw.write("Hello World！");
				pw.flush();

				// 5、关闭资源
				pw.close();
				os.close();
				br.close();
				isr.close();
				is.close();
				socket.close();
				// serverSocket.close();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
