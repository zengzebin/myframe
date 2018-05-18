package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// InputStream字节输入流

		try {
			File f = new File("d:" + File.separator + "test.txt");
			InputStream in = new FileInputStream(f);
			System.out.println("长度:" + (int) f.length());
 			byte[] b = new byte[(int) f.length()];// 我们可以根据文件的大小来定义字节数组的大小
//			in.read(b);

			for (int i = 0; i < b.length; i++) { // 也可以循环读 
				b[i] = (byte)in.read();
				System.out.println(b[i]);
			}

			System.out.println(new String(b));
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
