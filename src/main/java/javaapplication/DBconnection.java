package javaapplication;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBconnection {
	private static final String DB_DRIVER=  
			"com.mysql.cj.jdbc.Driver";
	private static final String DB_URL=
			"jdbc:mysql://localhost:3306/project";
	private static final String DB_USERNAME="root";
	private static final String DB_PASSWORD="jobina@123";
	public Connection getconnection() {
		Connection conn=null;
		try {
			Class.forName(DB_DRIVER);
			conn= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			if (conn!=null) {
				System.out.println("successfully connected");
			}
			else {
				System.out.println("failed to connect");
			}
			
			}catch(Exception e) {
				e.printStackTrace();
		
		}

		return conn;
	}

public static void main(String[] args) {
	 DBconnection obj=new DBconnection();
	obj.getconnection();
}
	}


