package phonebook;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			String db       = "jdbc:mysql://localhost/contactDB?autoReconnect=true&useSSL=false";
			String user     = "root";
			String password = "";
			Connection con = (Connection)DriverManager.getConnection(db,user,password);
				return con;
		}catch(SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
}
