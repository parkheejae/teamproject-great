package controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TodayProductController implements Controller {
    //이것은 사용하려다 안했습니다.
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<String> images = new ArrayList<String>();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i=0; i<cookies.length; i++) {
				if(cookies[i].getName().startsWith("image")) { // 도메인 이름을 넣어야하지만 그냥 image로시작하는 걸 다받아옴
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
