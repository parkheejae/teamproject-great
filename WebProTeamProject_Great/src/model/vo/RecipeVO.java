package model.vo;

public class RecipeVO {
	private int num;
	private String name;
	private String imgurls;
	private String main_ingredients;
	private String sub_ingredients;
	private String writer;
	private String date;
	private String type;
	private int hits;
	private String descript;
	private String content;
	private String tip;

	private String recommend;

	
	public RecipeVO() {
		super();}
		// TODO Auto-generated constructor stub

		
	
	public RecipeVO(int num, String name, String imgurls, String main_ingredientents, String sub_ingredientents,
			String writer, String date, String type, int hits, String descript, String content, String tip) {
		super();
		this.num = num;
		this.name = name;
		this.imgurls = imgurls;
		this.main_ingredients = main_ingredientents;
		this.sub_ingredients = sub_ingredientents;
		this.writer = writer;
		this.date = date;
		this.type = type;
		this.hits = hits;
		this.descript = descript;
		this.content = content;
		this.tip = tip;
	}

	
	public RecipeVO(int num, String name, String imgurls, String main_ingredients,String writer, String date, String type, int hits) {
			super();
			this.num = num;
			this.name = name;
			this.imgurls = imgurls;
			this.main_ingredients= main_ingredients;
			this.writer = writer;
			this.date = date;
			this.type = type;
			this.hits = hits;
		}
	
	public RecipeVO(int num, String name, String imgurls, String writer, String recommend) {
		super();
		this.num = num;
		this.name = name;
		this.imgurls = imgurls;
		this.writer = writer;
		this.recommend = recommend;
	}



	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;}


	public RecipeVO(int num, String name, String imgurls, String main_ingredientents, String sub_ingredientents,

			String writer, String register_date, String type, int hits, String descript, String content, String tip,

			String recommend) {

		super();
		this.num = num;
		this.name = name;
		this.imgurls = imgurls;
		this.main_ingredients = main_ingredientents;
		this.sub_ingredients = sub_ingredientents;
		this.writer = writer;
		this.date = date;
		this.type = type;
		this.hits = hits;
		this.descript = descript;
		this.content = content;
		this.tip = tip;
		this.recommend = recommend;
	}

	public RecipeVO(String name, String imgurls, String main_ingredientents, String sub_ingredientents, String writer,
			String type, String descript, String content, String tip) {
		super();
		
		this.name = name;
		this.imgurls = imgurls;
		this.main_ingredients = main_ingredientents;
		this.sub_ingredients = sub_ingredientents;
		this.writer = writer;
		
		this.type = type;
		
		this.descript = descript;
		this.content = content;
		this.tip = tip;
		
	}



	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgurls() {
		return imgurls;
	}

	public void setImgurls(String imgurls) {
		this.imgurls = imgurls;
	}

	public String getMain_ingredients() {
		return main_ingredients;
	}

	public void setMain_ingredients(String main_ingredients) {
		this.main_ingredients = main_ingredients;
	}

	public String getSub_ingredients() {
		return sub_ingredients;
	}

	public void setSub_ingredients(String sub_ingredients) {
		this.sub_ingredients = sub_ingredients;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	@Override
	public String toString() {
		return "RecipeVO [num=" + num + ", name=" + name + ", imgurls=" + imgurls + ", main_ingredients="
				+ main_ingredients + ", sub_ingredients=" + sub_ingredients + ", writer=" + writer + ", date="
				+ date + ", type=" + type + ", hits=" + hits + ", descript=" + descript + ", content=" + content
				+ ", tip=" + tip + "]";
	}

}