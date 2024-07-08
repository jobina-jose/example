package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaapplication.DBconnection;
import javaapplication.DBoperation;

/**
 * Servlet implementation class servletoperation
 */
@WebServlet("/servletoperation")
public class servletoperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletoperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    String address = request.getParameter("address");
	    String place = request.getParameter("place");
	    String phoneno = request.getParameter("phoneno");

	    // Log parameters for debugging
	    System.out.println("Received parameters:");
	    System.out.println("Name: " + name);
	    System.out.println("Email: " + email);
	    System.out.println("Password: " + password);
	    System.out.println("Address: " + address);
	    System.out.println("Place: " + place);
	    System.out.println("Phone Number: " + phoneno);

	
	    // Ensure phone number is numeric
	    long phoneNumber;
	    try {
	        phoneNumber = Long.parseLong(phoneno);
	    } catch (NumberFormatException e) {
	        response.getWriter().append("Invalid phone number format");
	        return;
	    }

	    DBconnection db = new DBconnection();
	    DBoperation op = new DBoperation(db.getconnection());

	    try {
	        op.createTable();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        response.getWriter().append("Error creating table: ").append(e.getMessage());
	        return;
	    }

	    try {
	        op.insertData(name, email, password, address, place, phoneno);
	        response.getWriter().append("Data inserted successfully");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        response.getWriter().append("Error inserting data: ").append(e.getMessage());
	    }
	}



}
