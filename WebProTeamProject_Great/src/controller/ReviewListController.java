package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.NoticeListVO;
import service.ReviewListVO;

public class ReviewListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNo = request.getParameter("page");
		System.out.println(pageNo+ " What page is it? ");
		
		ReviewListVO lvo = BoardService.getInstance().showReview(pageNo);
		
		request.setAttribute("lvo", lvo);
		return new ModelAndView("review.jsp");
	}

}
