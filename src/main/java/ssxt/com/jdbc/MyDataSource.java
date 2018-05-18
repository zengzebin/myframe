package ssxt.com.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

import common.util.ConstParam;

public class MyDataSource {
	private static String url = null;
	private static String password = null;
	private static String user = null;
	private static String DriverClass = null;
	private static LinkedList<Connection> pool = new LinkedList<Connection>();

	/**
	 * 10 * 一个基本的数据连接池： 11 * 1、初始化时就建立一个容器，来存储一定数量的Connection 对象 12 *
	 * 2、用户通过调用MyDataSource 的getConnection 来获取Connection 对象。 13 * 3、再通过release
	 * 方法来回收Connection 对象，而不是直接关闭连接。 14 * 4、遵守先进先出的原则。 15 * 16 * 17 * @author
	 * 贺佐安 18 * 19
	 */

	// 注册数据库驱动
	static {
		try {
			System.out.println("初始静态化");
			user = ConstParam.getProperty("jdbc.username");
			url = ConstParam.getProperty("jdbc.url");
			password = ConstParam.getProperty("jdbc.password");
			DriverClass = ConstParam.getProperty("jdbc.driverClassName");
			Class.forName(DriverClass);
			
			for (int i = 0; i < 2; i++) {
				try {
					Connection conn = DriverManager.getConnection(url, user, password);
					pool.add(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	 
	// 、从连接池获取连接
    public static Connection getConnection() throws SQLException {
		return pool.remove();
	} // 回收连接对象。

	public static void release(Connection conn) {
		System.out.println(conn + "被回收");
 
		pool.addLast(conn);
	}

	public static int getLength() {
		return pool.size();
	}
}
