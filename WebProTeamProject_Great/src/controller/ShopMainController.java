package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowDao;
import model.dao.ProductDAO;
import model.dao.RecipeDAO;
import model.vo.ProductVO;
import model.vo.RecipeVO;
import service.PListVO;
import service.RPService;

public class ShopMainController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNo = request.getParameter("pageNo");
		String type = request.getParameter("type");
		PListVO plist = RPService.getInstance().showTypeProduct(type, pageNo);
		ArrayList<RecipeVO> list1 = RecipeDAO.getInstance().showRecipeRecommend();
		ArrayList<RecipeVO> list2 = RecipeDAO.getInstance().showRecipeHot();
		request.setAttribute("plist", plist);
		request.setAttribute("RecommendRlist", list1);
		request.setAttribute("HotRlist", list2);
		request.setAttribute("type", type);


		ModelAndView mv = new ModelAndView();
		System.out.println("ModelAndView...»ý¼º...");
		mv.setPath("shopMain.jsp");
		// mv.setRedirect(true);
		return mv;
	}

}
