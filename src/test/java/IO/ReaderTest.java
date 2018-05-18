package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/*
			 * 字符输入流：Reader Reader是使用字符的方式从文件中取出数据
			 */
			File f = new File("d:" + File.separator + "test.txt");

			Reader input = new FileReader(f);
			char[] c = new char[1024];//以字符数组的形式读取出数据：
			int len = input.read(c);
			System.out.println(new String(c, 0, len));
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// int len=input.read(c);
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
