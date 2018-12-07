package model.vo;

public class ReviewVO {
	
	
	private int no;
	private String title;
	private String writer;
	private String img_urls;
	private String register_date;
	private String content;
	private String about;
	
	public ReviewVO() {}
	

	
	
	
	public ReviewVO(String title, String writer, String img_urls, String content, String about) {
		super();
		this.title = title;
		this.writer = writer;
		this.img_urls = img_urls;
		this.content = content;
		this.about = about;
	}


	






	











	public String getAbout() {
		return about;
	}





	public void setAbout(String about) {
		this.about = about;
	}





	public ReviewVO(int no, String title, String writer, String img_urls, String register_date, String content,
			String about) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.img_urls = img_urls;
		this.register_date = register_date;
		this.content = content;
		this.about = about;
	}





	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getImg_urls() {
		return img_urls;
	}
	public void setImg_urls(String img_urls) {
		this.img_urls = img_urls;
	}
	public String getRegister_date() {
		return register_date;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}





	@Override
	public String toString() {
		return "ReviewVO [no=" + no + ", title=" + title + ", writer=" + writer + ", img_urls=" + img_urls + ", date="
				+ register_date + ", content=" + content + "]";
	}
	
	
}
