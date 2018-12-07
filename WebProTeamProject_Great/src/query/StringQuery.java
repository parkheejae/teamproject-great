package query;

import model.dao.CommonConstants;

public interface StringQuery {

	String NOTICE = "SELECT no, writer, img_urls, register_date, content FROM notice";
	
	String PAGE_NOTICE_LIST = "SELECT no, writer, title,register_date, content from" +
            "(SELECT no, writer, title,register_date, content, ceil(rownum/"+CommonConstants.CONTENT_NUMBER_PER_PAGE+") AS page FROM" +
            "(SELECT no, writer, title,to_char(register_date, 'YYYY.MM.DD') register_date, content FROM notice order by no desc)) where page=?";
	String MAIN_NOTICE_LIST = "SELECT no, writer, title,register_date, content from" +
            "(SELECT no, writer, title,to_char(register_date, 'YYYY.MM.DD') register_date, content FROM notice order by no desc) where rownum<6";

	String TOTAL_NOTICE_COUNT = "select count(-1) from NOTICE";
	
	//조회수 순으로 내림차순 정렬후 상위 4개의 레서피를 검색합니다.
	String SELECT_SHOWHOTRECIPE = "SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n" + 
				"hits, descript, content, tip,recommend from \r\n" + 
				"(SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n" + 
				"hits, descript, content, tip,recommend from recipe order by hits desc)\r\n" + 
				"where ROWNUM<=4";
	//시퀀스 넘버에따른 제일 새로등록된 레서피 4개
	String SELECT_SHOWNEWRECIPE = "SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n" + 
				"hits, descript, content, tip,recommend from \r\n" + 
				"(SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n" + 
				"hits, descript, content, tip,recommend from recipe order by no desc)\r\n" + 
				"where ROWNUM<=4";
		
	//추천레서피 관리자가 지정해서 추천레서피 2개
	String SELECT_SHOWRECOMMENDRECIPE = "SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,\r\n" + 
				"hits, descript, content, tip,recommend from recipe where recommend='chu' AND ROWNUM<=2";
		
	//판매량 순 내림차순 정렬후 상위 4개 상품 검색
	String SELECT_SHOWHOTPRODUCT = "SELECT name, price ,origin ,img_urls, content, type,\r\n" + 
				"brand, sales_volume,recommend from \r\n" + 
				"(SELECT name, price ,origin ,img_urls, content, type,\r\n" + 
				"brand, sales_volume,recommend from product order by sales_volume desc)\r\n" + 
				"WHERE ROWNUM<=3";
		
	//추천 상품 관리자가 지정해서 추천 레서피 2개
	String SELECT_SHOWRECOMMENDPRODUCT = "SELECT name, price ,origin ,img_urls, content, type,\r\n" + 
				"brand, sales_volume,recommend from product WHERE recommend='chu' AND ROWNUM<=2";
		
		
	String INSERT_RECIPE = 
				"INSERT INTO RECIPE (no ,name ,img_urls ,main_ingredients ,sub_ingredients ,writer ,register_date ,type ,hits ,descript ,content ,tip)"
				+ " VALUES(recipe_seq.nextVal,?, ?, ?, ?, ?, sysdate, ?, 4, ?, ?, ? )";
		
	String INSERT_REVIEW = 
				"INSERT INTO REVIEW (no ,writer ,img_urls ,register_date ,content)"
				+ " VALUES(review_seq.nextVal, ?, ?, sysdate, ?)";
		
	String INSERT_PRODUCT = 
				"INSERT INTO PRODUCT (name ,price ,origin ,imgurls ,content ,type ,brand, sales_volume , recommend )"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?,?,?)";
		
	String CURRENT_RECIPE="select recipe_seq.currVal from dual";
	
	String DELETE_RECIPE="DELETE FROM recipe WHERE no=?";
		
	String DELETE_REVIEW="DELETE FROM review WHERE no=?";
	
	String DELETE_PRODUCT="DELETE FROM product WHERE name=?";
	
	String UPDATE_RECIPE="UPDATE recipe SET name=?, img_urls=? , main_ingredients=?, sub_ingredients=?, writer=?, type=?, hits=?, descript=?, content=?, tip=? WHERE no=?";
	
	String UPDATE_REVIEW="UPDATE review SET writer=? , img_urls=?, content=? WHERE no=?";
		
	String UPDATE_PRODUCT="UPDATE product SET price=? , origin=?, imgurls=?, content=?, type=?, brand=? ,recommend=? ,sales_volume=? WHERE name=?";
		
		
	String INSERT_MEMBER = "INSERT INTO member "
		            + "VALUES(?,?,?,?,?,?,0,'chobo')";

	String SELECT_CHECK_ID = "SELECT count(-1) FROM member "
		              + "WHERE id=?";
	String SELECT_SEARCH_ID = "SELECT id FROM member "
		              + "WHERE name=? AND ssn=?";

	String SELECT_SEARCH_PASSWORD = "SELECT password FROM member "
		                     + "WHERE id=? AND name=? AND ssn=?";

	String UPDATE_MEMBER = "UPDATE member SET password=?, name=?, nickname=? WHERE id=?";

	String LOGIN_MEMBER = "SELECT * FROM member "
		           + "WHERE id=? AND password=?";

	String SEARCH_MEMBER = "SELECT id, password FROM member WHERE id=?";
	
	String UPDATE_HITS = "UPDATE notice SET hits=?+1 WHERE no=?";
	
	String SELECT_NOTICE = "SELECT no, writer, register_date, title, hits, content FROM notice WHERE no=?";
	
	   String INSERT_PURCHASE = "INSERT INTO purchase(purchase_date, pro_name, pro_price, pro_amount, img_urls, delivery_date) VALUES "
		         + "(SYSDATE,?,?,?,?,SYSDATE+3)";
		   
		   String INSERT_CART = "INSERT INTO cart(userId, name, price, quantity, img_urls) VALUES(?,?,?,?,?)";
		   
		   String SEARCH_CART = "SELECT userId, name, price, quantity, img_urls FROM cart WHERE name=?";
}
