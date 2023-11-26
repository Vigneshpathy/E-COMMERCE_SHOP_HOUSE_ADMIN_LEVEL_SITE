package shophouse.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shophouse.dao.Dao;
import shophouse.dto.Admin;
@WebServlet("/LogInPage")
public class LogIn extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email= req.getParameter("email");
		String password = req.getParameter("password");
		
		Dao dao = new Dao();
		
		try {
			Admin admin=dao.adminLogin(email, password);
			if (admin!=null) {
				
				RequestDispatcher rd = req.getRequestDispatcher("/Home.jsp");
				req.getSession().setAttribute("admin", admin);
				req.getSession().setAttribute("products", dao.findAll());
				rd.include(req, resp);
				
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("/LogIn.jsp");
				req.setAttribute("message","email or password is wrong.");
				rd.forward(req, resp);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
