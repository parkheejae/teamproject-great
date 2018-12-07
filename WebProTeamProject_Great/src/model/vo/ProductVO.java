
package model.vo;

public class ProductVO {
	private String name;
	private int price;
	private String origin;
	private String img_urls;
	private String content;
	private String type;
	private String brand;
	private int sales_volume;
	private String recommend;
	private String amount;

	   
	   //상품 상세보기
	   public ProductVO(String name, int price, String origin, String img_urls, String content, String type, String brand,
	         String amount) {
	      super();
	      this.name = name;
	      this.price = price;
	      this.origin = origin;
	      this.img_urls = img_urls;
	      this.content = content;
	      this.type = type;
	      this.brand = brand;
	      this.amount = amount;
	   }

	public ProductVO(String name, int price, String origin, String img_urls, String content) {
		super();
		this.name = name;
		this.price = price;
		this.origin = origin;
		this.img_urls = img_urls;
		this.content = content;
	}
	   public ProductVO(String name, int price, String origin, String img_urls, String content, String type) {
		super();
		this.name = name;
		this.price = price;
		this.origin = origin;
		this.img_urls = img_urls;
		this.content = content;
		this.type = type;
	}
	
	
	public ProductVO(String name, String img_urls) {
		super();
		this.name = name;
		this.img_urls = img_urls;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public ProductVO() {}

	public ProductVO(String name, int price, String origin, String img_urls, String content, String type, String brand,
			int sales_volume, String recommend) {
		super();
		this.name = name;
		this.price = price;
		this.origin = origin;
		this.img_urls = img_urls;
		this.content = content;
		this.type = type;
		this.brand = brand;
		this.sales_volume = sales_volume;
		this.recommend = recommend;
	}
	
	public ProductVO(String name, int price, String origin, String img_urls, String content, String type, String brand,
			int sales_volume, String recommend, String amount) {
		super();
		this.name = name;
		this.price = price;
		this.origin = origin;
		this.img_urls = img_urls;
		this.content = content;
		this.type = type;
		this.brand = brand;
		this.sales_volume = sales_volume;
		this.recommend = recommend;
		this.amount = amount;
	}
	
	
	public ProductVO(String name, int price, String img_urls, String type) {
		super();
		this.name = name;
		this.price = price;
		this.img_urls = img_urls;
		this.type = type;
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

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getImg_urls() {
		return img_urls;
	}

	public void setImg_urls(String img_urls) {
		this.img_urls = img_urls;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getSales_volume() {
		return sales_volume;
	}

	public void setSales_volume(int sales_volume) {
		this.sales_volume = sales_volume;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + ", origin=" + origin + ", img_urls=" + img_urls
				+ ", content=" + content + ", type=" + type + ", brand=" + brand + ", sales_volume=" + sales_volume
				+ ", recommend=" + recommend + "]";
	}
}
