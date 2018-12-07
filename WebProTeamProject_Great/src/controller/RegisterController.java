package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.vo.MemberVO;

public class RegisterController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(id, password, name, email, date, address);
		System.out.println(vo);
		MemberDAO.getInstance().registerMember(vo);
		
		return new ModelAndView("loginForm.jsp");
	}
}
