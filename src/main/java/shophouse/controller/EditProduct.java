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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import shophouse.dao.Dao;
import shophouse.dto.Admin;
import shophouse.dto.Product;

@MultipartConfig(maxFileSize = 1617721)
@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		Dao dao = new Dao();
		Product product = new Product();
		product.setProductId(Integer.parseInt(req.getParameter("id")));
		product.setProductName( req.getParameter("name"));
		product.setProductBrand(req.getParameter("brand"));
		product.setProductPrice(Double.parseDouble(req.getParameter("price")));
		product.setProductDiscount(Double.parseDouble(req.getParameter("discount")));
		Part image = req.getPart("image");
		
		if (image.getSize()>1) {
			InputStream is = image.getInputStream();
			byte[] picture = is.readAllBytes();
			product.setProductImage(picture);
		}
		else {	
			
			try {
				product.setProductImage(dao.findProductById(Integer.parseInt(req.getParameter("id"))).getProductImage());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			dao.updateProduct(product);
			hs.setAttribute("products", dao.findAll());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hs.setAttribute("admin",(Admin)hs.getAttribute("admin"));
		RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
		rd.include(req, resp);
	}
}
