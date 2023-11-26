package shophouse.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shophouse.dao.Dao;
@WebServlet("/delete")
public class DeleteProduct extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		Dao dao = new Dao();
		HttpSession hs = req.getSession();
		try {
			dao.deleteProduct(id);
			hs.setAttribute("products", dao.findAll());
			hs.setAttribute("admin", hs.getAttribute("admin"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
		rd.include(req, resp);
	}
}
