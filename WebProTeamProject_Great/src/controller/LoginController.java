package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.vo.MemberVO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "login_form.jsp?error=idpw";
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String temp = request.getParameter("callurl");
		System.out.println(id+"//"+password+"//"+temp);
		MemberVO vo = MemberDAO.getInstance().login(id, password);
		System.out.println(vo);
		if(vo !=null){
			HttpSession session = request.getSession();
			session.setAttribute("login", vo);
			if(!temp.equals("")) path= temp.replaceAll("/","");
			else path = "showmain.do";
		}
		
		System.out.println(vo);
		return new ModelAndView(path);
	}
}
