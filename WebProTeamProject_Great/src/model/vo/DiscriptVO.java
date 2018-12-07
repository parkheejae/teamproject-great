package model.vo;

public class DiscriptVO {
	String discript;
	String urls;
	
	public DiscriptVO(String discript, String urls) {
		super();
		this.discript = discript;
		this.urls = urls;
	}

	
	public DiscriptVO(String discript) {
		super();
		this.discript = discript;
	}


	public String getDiscript() {
		return discript;
	}


	public void setDiscript(String discript) {
		this.discript = discript;
	}


	public String getUrls() {
		return urls;
	}


	public void setUrls(String urls) {
		this.urls = urls;
	}


	@Override
	public String toString() {
		return "DiscriptVO [discript=" + discript + ", urls=" + urls + "]";
	}
	
	

}
