package service;

import java.util.ArrayList;

import model.dao.BoardDAO;
import model.dao.PagingBean;
import model.vo.BoardVO;
import model.vo.ReviewVO;

public class BoardService {
	private BoardDAO dao;
	private static BoardService service = new BoardService();
	private BoardService() {
		dao = BoardDAO.getInstance();
	}
	public static BoardService getInstance() {
		return service;
	}
	
	public NoticeListVO showNotice(String pageNo) throws Exception {
		int pn =1;
		if(pageNo !=null) pn = Integer.parseInt(pageNo);
		
		ArrayList<BoardVO> list = dao.showNotice(pn);
		int total = dao.getTotalPostingCount();
		PagingBean pb = new PagingBean(total,pn);
		
		return new NoticeListVO(pb,list);
		
	}
	public ArrayList<BoardVO> showMainNotice() throws Exception {
		
		
		ArrayList<BoardVO> list = dao.showMainNotice();
		
		
		return list;
		
	}
	
	public ReviewListVO showReview(String pageNo) throws Exception {
		int pn =1;
		if(pageNo !=null) pn = Integer.parseInt(pageNo);
		
		ArrayList<ReviewVO> list = dao.showReview(pn);
		int total = dao.getTotalReviewCount();
		PagingBean pb = new PagingBean(total,pn);
		
		return new ReviewListVO(pb,list);
		
	}
	public ReviewListVO showReview(String pageNo, String about) throws Exception {
		int pn =1;
		if(pageNo !=null) pn = Integer.parseInt(pageNo);
		
		ArrayList<ReviewVO> list = dao.showReview(pn, about);
		int total = dao.getAboutReviewCount(about);
		PagingBean pb = new PagingBean(total,pn);
		
		return new ReviewListVO(pb,list);
		
	}
	
}
