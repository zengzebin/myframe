package ssxt.com.jdbc;

import java.sql.SQLException;

import java.sql.Connection;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		 for (int i = 0; i <100; i++) {
			 Connection   con=MyDataSource.getConnection();
		 	 System.out.println(con);
			 MyDataSource.release(con);
			 Thread.sleep(5000);
	 	}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
