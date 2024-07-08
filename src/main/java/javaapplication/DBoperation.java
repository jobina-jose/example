package javaapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBoperation {
	 private Connection conn=null;

	    public DBoperation(Connection conn) {
	        this.conn = conn;
	    }

	    public void createTable() throws SQLException,NullPointerException {
	        try (Statement stmt = conn.createStatement()) {
	            stmt.execute("CREATE TABLE IF NOT EXISTS persons (id INT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(100),email VARCHAR(100),password varchar(100), address VARCHAR(100),place varchar(100), phoneno BIGINT)");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void insertData(String name, String email, String password, String address, String place, String phoneno) throws SQLException, NullPointerException {
	        // Validate phone number
	        long phoneNumber;
	        try {
	            phoneNumber = Long.parseLong(phoneno);
	        } catch (NumberFormatException e) {
	            throw new SQLException("Invalid phone number format", e);
	        }

	        try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO persons (name, email, password, address, place, phoneno) VALUES (?, ?, ?, ?, ?, ?)")) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, email);
	            pstmt.setString(3, password);
	            pstmt.setString(4, address);
	            pstmt.setString(5, place);
	            pstmt.setLong(6, phoneNumber); // Ensure phoneno is a valid long
	            pstmt.executeUpdate();
	        }
	    }

public boolean logindata(String email,String password) throws SQLException, NullPointerException{
	String query="SELECT*FROM persons WHERE email = ? AND password = ?";
try (PreparedStatement pstmt = conn.prepareStatement(query)){
	pstmt.setString(1, email);
	pstmt.setString(2, password);

	try (ResultSet rs = pstmt.executeQuery()) {
        return rs.next();
}
}
}
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;


public void updatedata(String name, String email, String password, String address, String place, String phoneno, Long id) throws SQLException {
    String query = "UPDATE persons SET name=?, email=?, password=?, address=?, place=?, phoneno=? WHERE id=?";
    PreparedStatement pstmt = conn.prepareStatement(query);
    pstmt.setString(1, name);
    pstmt.setString(2, email);
    pstmt.setString(3, password);
    pstmt.setString(4, address);
    pstmt.setString(5, place);
    pstmt.setString(6, phoneno);
    pstmt.setLong(7, id);
    pstmt.executeUpdate();
}
}


//    public static void main(String[] args) {
//        YourClassName instance = new YourClassName();
//        try {
//            instance.updatedata("John Doe", "john@example.com", "newpassword", "123 Main St", "Hometown", "1234567890", 1);
//        } catch (SQLException | NullPointerException e) {
//            e.printStackTrace();
//        }
//    }
//}
