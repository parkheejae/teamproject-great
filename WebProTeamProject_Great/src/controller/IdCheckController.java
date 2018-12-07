package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class IdCheckController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");

		boolean flag = MemberDAO.getInstance().idExist(id);
		request.setAttribute("flag", flag);
		
		return new ModelAndView("idcheck.jsp");
	}
}
