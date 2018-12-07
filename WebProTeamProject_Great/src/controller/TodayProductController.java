package controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TodayProductController implements Controller {
    //�̰��� ����Ϸ��� ���߽��ϴ�.
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<String> images = new ArrayList<String>();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i=0; i<cookies.length; i++) {
				if(cookies[i].getName().startsWith("image")) { // ������ �̸��� �־�������� �׳� image�ν����ϴ� �� �ٹ޾ƿ�
					images.add(cookies[i].getValue());
				}//if
			}//for
		}
		request.setAttribute("images", images);
		ModelAndView mv = new ModelAndView();
		mv.setPath("header.jsp");
		return mv;
	}
}
