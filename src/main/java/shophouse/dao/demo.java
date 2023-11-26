package shophouse.dao;

import java.sql.SQLException;

import shophouse.dto.Product;

public class demo 
{
	public static void main(String[] args) {
		Dao d=new Dao();
		try {
			Product product = d.findProductById(1);
			System.out.println(product.getProductName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
