package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.NoticeListVO;
/*
 * BoardServic�� �޼ҵ� ȣ��
 */
public class NoticeListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNo = request.getParameter("page");
		System.out.println(pageNo+ " What page is it? ");
		
		NoticeListVO lvo = BoardService.getInstance().showNotice(pageNo);
		request.setAttribute("lvo", lvo);
		return new ModelAndView("show_list.jsp");
	}
}
