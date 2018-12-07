package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowDao;
import model.vo.ProductVO;
import model.vo.RecipeVO;
import service.BoardService;
import service.NoticeListVO;
import service.PListVO;
import service.RPService;

public class ShowProductController2 implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//헤더에서 SHOP들어갈때 나올때 사용하는 컨트롤로입니다.
		String pageNo = request.getParameter("pageNo");
		System.out.println(pageNo+ " What page is it? ");
		PListVO plvo = RPService.getInstance().showProduct(pageNo);
		System.out.println("아마도 여기??");
		ArrayList<RecipeVO> list2 = ShowDao.getInstance().showRecipeRecommend();
		ArrayList<RecipeVO> list3 = ShowDao.getInstance().showRecipeHot();
		
		request.setAttribute("plvo", plvo);
		request.setAttribute("rplist", list2);
		request.setAttribute("rhlist", list3);
		
		ModelAndView mv = new ModelAndView();
		System.out.println("ModelAndView...생성...");
		mv.setPath("showProduct.jsp");
		return mv;
	}

}
