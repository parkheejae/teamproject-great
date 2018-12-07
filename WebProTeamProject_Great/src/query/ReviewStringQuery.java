package query;

import model.dao.CommonConstants;

public interface ReviewStringQuery {

	String INSERT_REVIEW = "INSERT INTO review(NO, WRITER, IMG_URLS, REGISTER_DATE, CONTENT, TITLE, about)"
			+ "VALUES(review_seq.nextVal, ?, ?, sysdate, ?, ?,?)";
	
	String CURRENT_NO = "SELECT review_seq.currVal FROM dual";
		
	String GET_REVIEW_BY_NO = "select * from review where no = ?";
	
	String DELETE_REVIEW = "delete from review where no=?";
	
	String UPDATE_REVIEW = "update review set title=?, content=? where no=?";

	String REVIEW_COUNT = "select count(-1) from review" ;
	String REVIEW_ABOUT_COUNT = "select count(-1) from review where about = ?" ;
	String REVIEW_ABOUT_LIST = "SELECT no, writer, TITLE , img_urls, register_date, content,about FROM" +
            "(SELECT no, writer, TITLE , img_urls,register_date, content, about,  ceil(rownum/"+CommonConstants.CONTENT_NUMBER_PER_PAGE+") AS page FROM" +
            "(SELECT no, writer, TITLE , img_urls, to_char(register_date, 'YYYY.MM.DD') register_date, content,about FROM review order by no desc)) where page=? AND about=?";
	
	String REVIEW_PAGE_LIST = "SELECT no, writer, TITLE , img_urls, register_date, content,about FROM" +
            "(SELECT no, writer, TITLE , img_urls,register_date, content, about,  ceil(rownum/"+CommonConstants.CONTENT_NUMBER_PER_PAGE+") AS page FROM" +
            "(SELECT no, writer, TITLE , img_urls, to_char(register_date, 'YYYY.MM.DD') register_date, content,about FROM review order by no desc)) where page=?";

	
}
	
	
