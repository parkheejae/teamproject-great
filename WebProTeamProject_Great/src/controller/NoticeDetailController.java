package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.BoardVO;
import model.dao.BoardDAO;

public class NoticeDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no=  Integer.parseInt(request.getParameter("no"));
		String nowpage =request.getParameter("nowpage");
		BoardVO rvo=BoardDAO.getInstance().getNoticeByNo(no);
		
		request.setAttribute("page", nowpage);
		request.setAttribute("rvo", rvo);
		return new ModelAndView("show_content.jsp",false);//forward¹æ½Ä
	}

}
