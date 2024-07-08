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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println("Received parameters:");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    
        

        if (email == null || password == null) {
            response.getWriter().append("Email or password is missing");
            return;
        }

        DBconnection db = new DBconnection();
        DBoperation op = new DBoperation(db.getconnection());
        try {
            boolean isValidUser = op.logindata(email, password);
            if (isValidUser) {
                response.getWriter().append("Login successful");
            } else {
                response.getWriter().append("Invalid email or password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().append("Error validating user: ").append(e.getMessage());
        }
    }
		
		
		
		
//		doGet(request, response);
		}


