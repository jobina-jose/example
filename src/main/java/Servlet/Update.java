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

@WebServlet("/Update")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Update() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String place = request.getParameter("place");
        String phoneno = request.getParameter("phoneno");
        Long id = Long.parseLong(request.getParameter("id")); // Assuming 'id' is passed in the request

        System.out.println("Received parameters:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Address: " + address);
        System.out.println("Place: " + place);
        System.out.println("Phone Number: " + phoneno);
        System.out.println("ID: " + id);

        DBconnection dbc = new DBconnection();
        DBoperation obj = new DBoperation(dbc.getconnection());

        try {
            obj.updatedata(name, email, password, address, place, phoneno, id);
            response.getWriter().write("Update successful!");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Update failed: " + e.getMessage());
        }
    }
}
