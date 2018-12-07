package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowDao;
import model.dao.ProductDAO;
import model.dao.RecipeDAO;
import model.vo.BoardVO;
import model.vo.ProductVO;
import model.vo.RecipeVO;
import service.BoardService;
import service.NoticeListVO;


public class ShowMainController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("show hotP 뭐가 안됬을까?");
		ArrayList<RecipeVO> list1 = RecipeDAO.getInstance().showRecipeRecommend();
		System.out.println("1");
		ArrayList<RecipeVO> list2 = RecipeDAO.getInstance().showRecipeHot();
		System.out.println("2");
		ArrayList<ProductVO> list3 = ProductDAO.getInstance().showProductHot();
		System.out.println("3");
		ArrayList<ProductVO> list4 = ProductDAO.getInstance().showProductRecommend();
		System.out.println("4");
		System.out.println(list2);
		request.setAttribute("RecommendRlist", list1);
		request.setAttribute("HotRlist", list2);
		request.setAttribute("HotPlist", list3);
		request.setAttribute("RecommendPlist", list4);
		
		ArrayList<BoardVO> bvo = BoardService.getInstance().showMainNotice();
		request.setAttribute("bvo", bvo);
		
		ModelAndView mv = new ModelAndView();
		System.out.println("ModelAndView...생성...");
		mv.setPath("recipemain.jsp");
		// mv.setRedirect(true);
		return mv;
	}

}
