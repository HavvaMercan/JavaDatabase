package guiProjArlanda1;
import java.sql.*;
public class connectSQL {
	
	static Connection conn = null;
	
	static final String DBDriver = "com.mysql.jdbc.Driver";
	static final String DBURL = "jdbc:mysql://localhost:3306/arlanda";
	static final String DBUSER = "root";
	static final String DBPASS = "";

	public static Connection dbConnector() {
		
		
		try {
			
			Class.forName(DBDriver);
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);	
			System.out.println("Connection ...... SUCCESSFUL");
			return conn;
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return null;

	}


}
