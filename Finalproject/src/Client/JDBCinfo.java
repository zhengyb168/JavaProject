package Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCinfo {
	protected static String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	protected static String user = "root";
	protected static String password = ",26187108hoog";
	protected static Connection myConn = getconnection();
	public static Connection getconnection(){
		
		try {
			Connection myConn = DriverManager.getConnection(url, user, password);
			return myConn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
