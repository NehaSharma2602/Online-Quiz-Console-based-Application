package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	Connection con=null;
	
	
	public static Connection getConnectionUtil() {
		Connection con=null;
		try {
		     //Driver Loading
			 Class.forName("org.postgresql.Driver");
			 System.out.println("Class Loading Done");
			 String url="jdbc:postgresql://localhost:5432/m10_jdbc_proc";
			 String user="postgres";
			 String pass="neha@123";
			 
			 //step-2 => Connection establishing
			  con=DriverManager.getConnection(url,user,pass);
			 System.out.println("connection Done ");
			 
			 //step-3 => statement creation
			 
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	public static void setCloseConnection(Connection con) {
		if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

}
