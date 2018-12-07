package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "recipemain.jsp";
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") != null) { 
			session.invalidate(); 
			path = "logout.jsp";
		}
		return new ModelAndView(path);
	}
}
