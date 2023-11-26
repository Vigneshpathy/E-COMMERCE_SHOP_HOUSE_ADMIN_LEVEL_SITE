package shophouse.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import shophouse.dto.Admin;
import shophouse.dto.Product;

public class Dao
{
    
	private static Connection getConnection() throws ClassNotFoundException, SQLException 
	{

		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/shophouse", "root", "handball22&&");
	}

	public int saveAdmin(Admin admin) throws ClassNotFoundException, SQLException {

		if (getCount() > 2) {
			return 0;
		}
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("insert into admin value(?,?,?,?,?)");

		ps.setInt(1, admin.getAdminId());
		ps.setString(2, admin.getAdminName());
		ps.setLong(3, admin.getAdminContact());
		ps.setString(4, admin.getAdminEmail());
		ps.setString(5, admin.getAdminPassword());

		return ps.executeUpdate();

	}

	public Admin adminLogin(String email, String password) throws SQLException, ClassNotFoundException 
	{
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select * from admin where email=?");
		ps.setString(1, email);
		Admin admin =null;
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			if (!password.equals(rs.getString(5)))
			{
				return null;

			}
			
			 admin = new Admin();
			 System.out.println(rs.getInt(1));
			admin.setAdminId(rs.getInt(1));
			admin.setAdminName(rs.getString(2));
			admin.setAdminContact(rs.getLong(3));
			admin.setAdminEmail(rs.getString(4));
			admin.setAdminPassword(rs.getString(5));
			
		}
		
		return admin;
	}

	public int addProduct(Product product) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("insert into product value(?,?,?,?,?,?)");

		ps.setInt(1, product.getProductId());
		ps.setString(2, product.getProductName());
		ps.setString(3, product.getProductBrand());
		ps.setDouble(4, product.getProductPrice());
		ps.setDouble(5, product.getProductDiscount());
		Blob image = new SerialBlob(product.getProductImage());
		ps.setBlob(6, image);
		int ex = ps.executeUpdate();
		con.close();
		return ex;

	}

	public int updateProduct(Product product) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con
				.prepareStatement("update product set name=? ,brand=?, price=?, discount=?, image=? where id=?");
		pst.setInt(6, product.getProductId());
		pst.setString(1, product.getProductName());
		pst.setString(2, product.getProductBrand());
		pst.setDouble(3, product.getProductPrice());
		pst.setDouble(4, product.getProductDiscount());
		Blob image = new SerialBlob(product.getProductImage());
		pst.setBlob(5, image);
		int ex = pst.executeUpdate();
		con.close();
		return ex;
	}

	public Product findProductById(int id) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from product where id = ?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		rs.next();
		Product product = new Product();
		product.setProductId(rs.getInt(1));
		product.setProductName(rs.getString(2));
		product.setProductBrand(rs.getString(3));
		product.setProductPrice(rs.getDouble(4));
		product.setProductDiscount(rs.getDouble(5));
		Blob blobImage = rs.getBlob(6);
		byte[] image = blobImage.getBytes(1, (int) blobImage.length());
		product.setProductImage(image);
		con.close();
		return product;
	}

	public ArrayList<Product> findAll() throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from product ");
		ResultSet rs = pst.executeQuery();
		ArrayList<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			Product product = new Product();
			product.setProductId(rs.getInt(1));
			product.setProductName(rs.getString(2));
			product.setProductBrand(rs.getString(3));
			product.setProductPrice(rs.getDouble(4));
			product.setProductDiscount(rs.getDouble(5));
			Blob blobImage = rs.getBlob(6);
			byte[] image = blobImage.getBytes(1, (int) blobImage.length());
			product.setProductImage(image);

			list.add(product);
		}
		con.close();
		return list;
	}

	private int getCount() throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select count(*) from admin ");
		ResultSet rs = pst.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		return count;
	}
	public int deleteProduct(int id) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("delete from product where id = ?");
		pst.setInt(1,id);
		int res=pst.executeUpdate();
		
		return res;
	}

}
