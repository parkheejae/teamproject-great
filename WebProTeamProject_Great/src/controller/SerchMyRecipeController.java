package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SearchDao;
import model.dao.ProductDAO;
import model.vo.MemberVO;
import model.vo.ProductVO;
import service.RListVO;
import service.RPService;

public class SerchMyRecipeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session =request.getSession();
		System.out.println("생성");
		String pageNo = request.getParameter("page");
		RListVO rlist=null;
		MemberVO mvo = (MemberVO) session.getAttribute("login");
		System.out.println("page : "+pageNo +"/mvo : "+mvo);
		
		System.out.println("searchmyrecipe!!!");
		if(mvo!=null) {
			String writer = mvo.getId();
			System.out.println("이리오는거 아니지!!");
			rlist =  RPService.getInstance().searchRecipeByWriter(writer, pageNo);
		}
		System.out.println("end!");
		ArrayList<ProductVO> list3 = ProductDAO.getInstance().showProductHot();
		System.out.println("3");
		ArrayList<ProductVO> list4 = ProductDAO.getInstance().showProductRecommend();
		System.out.println("4");
		request.setAttribute("HotPlist", list3);
		request.setAttribute("RecommendPlist", list4);
		
		System.out.println(rlist);
		request.setAttribute("rlist", rlist);
		
		System.out.println("mv반환");
		return new ModelAndView("searchMyRecipeResult.jsp");
	}

}
