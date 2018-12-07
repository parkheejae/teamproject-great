package controller;

import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowDao;
import model.vo.ProductVO;
import service.BoardService;
import service.PListVO;
import service.RPService;
import service.ReviewListVO;


public class ProductDetailController implements Controller {

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
	      String name=request.getParameter("name");
	      String name2=URLEncoder.encode(request.getParameter("name"),"UTF-8");
	      
	      System.out.println(name+ " search....");
	      System.out.println(name2);
	      
	      ArrayList<String> array= new ArrayList<String>();
	      array.add(name);
	      PListVO plist =  RPService.getInstance().searchProduct(array, "1");
	      ProductVO pvo=ShowDao.getInstance().showProduct(name); 
	      System.out.println("검색결과입니다 :: "+pvo);
	      
	      Cookie cookie = new Cookie("image"+name2, pvo.getImg_urls());
			cookie.setMaxAge(24*60*60); 
			response.addCookie(cookie);
			
			ArrayList<String> images = new ArrayList<String>();
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i=0; i<cookies.length; i++) {
					if(cookies[i].getName().startsWith("image")) { // 도메인 이름을 넣어야하지만 그냥 image로시작하는 걸 다받아옴
						images.add(cookies[i].getValue());
					}//if
				}//for
			}
			String pageNo ="1";
			pageNo= request.getParameter("page");
			System.out.println(pageNo+ " What page is it? ");
			ReviewListVO lvo = BoardService.getInstance().showReview(pageNo,name);
			
			request.setAttribute("lvo", lvo);
			
			request.setAttribute("images", images);
	      request.setAttribute("product", pvo);
	      request.setAttribute("plist", plist);
	      ModelAndView mv= new ModelAndView();
	      System.out.println("ModelAndView 생성...");
	      mv.setPath("productdetails.jsp");
	      System.out.println("productdetails.jsp로 값 전송함");
	      return mv;
   }
}