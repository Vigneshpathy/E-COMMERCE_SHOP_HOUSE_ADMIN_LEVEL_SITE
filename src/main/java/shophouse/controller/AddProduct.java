package shophouse.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import shophouse.dao.Dao;
import shophouse.dto.Admin;
import shophouse.dto.Product;

@MultipartConfig(maxFileSize = 1617721)
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
		
		Admin admin = (Admin) req.getSession().getAttribute("admin");
		
		req.getSession().setAttribute("admin", admin);
		Product product = new Product();
		product.setProductId(Integer.parseInt(req.getParameter("id")));
		product.setProductName( req.getParameter("name"));
		product.setProductBrand(req.getParameter("brand"));
		product.setProductPrice(Double.parseDouble(req.getParameter("price")));
		product.setProductDiscount(Double.parseDouble(req.getParameter("discount")));
		Part image = req.getPart("image");
		InputStream is = image.getInputStream();
		product.setProductImage(is.readAllBytes());

		Dao dao = new Dao();
		
		req.getSession().setAttribute("admin", admin);
		try {
			dao.addProduct(product);
			req.getSession().setAttribute("products", dao.findAll());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rd.include(req, resp);

	}
}
