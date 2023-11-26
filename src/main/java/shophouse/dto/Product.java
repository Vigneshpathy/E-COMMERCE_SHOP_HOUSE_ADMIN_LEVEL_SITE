package shophouse.dto;

public class Product {

	
	private int productId;
	private String productName;
	private String productBrand;
	private double productPrice;
	private double productDiscount;
	private byte[] productImage;
	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	public int getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public double getProductDiscount() {
		return productDiscount;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public void setProductPrice(double productPrize) {
		this.productPrice = productPrize;
	}
	public void setProductDiscount(double productDiscount) {
		this.productDiscount = productDiscount;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productBrand=" + productBrand
				+ ", productPrize=" + productPrice + ", productDiscount=" + productDiscount + "]";
	}
	
}
