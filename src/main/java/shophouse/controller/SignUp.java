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
@WebServlet("/SignUpPage")
public class SignUp extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long contact = Long.parseLong(req.getParameter("contact"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Admin admin = new Admin();
		admin.setAdminId(id);
		admin.setAdminName(name);
		admin.setAdminContact(contact);
		admin.setAdminEmail(email);
		admin.setAdminPassword(password);
		
		Dao dao =new Dao();
		try {
			int check = dao.saveAdmin(admin);
			if (check==1) {
				req.setAttribute("message", name+" is succussfully added");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.include(req, resp);
			}
			else {
				req.setAttribute("message", name+" is failed add");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
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
