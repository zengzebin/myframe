package IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 字符输出流：Writer Writer本身是一个字符流的输出类（写入文件）
		 */
		try {
			File f = new File("d:" + File.separator + "test.txt");

			Writer out = new FileWriter(f);
			// Writer out=new FileWriter(f,true);//追加
			String str = "Hello World";
			out.write(str);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
