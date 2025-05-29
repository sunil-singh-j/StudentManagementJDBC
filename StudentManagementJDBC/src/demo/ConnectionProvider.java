package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	static Connection con;

	public static Connection creatC() {
		
		try {
			
			//load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver"
					+ "");
			
			String user="root";
			String password="root";
			String url="jdbc:mysql://localhost:3306/student";
			
			con=DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
}
