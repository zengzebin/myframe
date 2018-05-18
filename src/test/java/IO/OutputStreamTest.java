package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OutputStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// OutputStream 类是输出字节流
		try {
			File f = new File("d:" + File.separator + "test.txt");

			OutputStream out = new FileOutputStream(f);// 字节输入如果文件不存在会自动创建 
		  //OutputStream out=new FileOutputStream(f,true);//追加内容加上true就可以
			String message = "你好呀aa";
			byte[] b = message.getBytes();
			out.write(b);// 因为是字节流所以必须转换为字节
			for (int i = 0; i < b.length; i++) {
				//也可以一个一个的输出
				out.write(b[i]);
          }
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
