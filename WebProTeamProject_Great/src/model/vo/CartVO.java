package model.vo;

public class CartVO {
	private String userId;
	private String name;
	private int price;
	private int quantity;
	private String img_urls;
	 
	public CartVO() {}
	public CartVO(String userId, String name, int price, int quantity, String img_urls) {
		super();
		this.userId = userId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.img_urls = img_urls;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getImg_urls() {
		return img_urls;
	}
	public void setImg_urls(String img_urls) {
		this.img_urls = img_urls;
	}
	
	
	@Override
	public String toString() {
		return "CartVO [userId=" + userId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
			+ ", img_urls=" + img_urls + "]";
	}
	
}
