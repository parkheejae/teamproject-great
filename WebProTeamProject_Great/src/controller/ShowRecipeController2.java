package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowDao;
import model.vo.ProductVO;
import service.RListVO;
import service.RPService;


public class ShowRecipeController2 implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//헤더에서 레시피들어갈때 나올때 사용하는 컨트롤로입니다.
		String pageNo = request.getParameter("pageNo");
		System.out.println(pageNo+ " What page is it? ");
				
		RListVO rlvo = RPService.getInstance().showRecipe(pageNo);
		ArrayList<ProductVO> list2 = ShowDao.getInstance().showProductHot();
		ArrayList<ProductVO> list3 = ShowDao.getInstance().showProductRecommend();
		System.out.println(list3.size());
		request.setAttribute("rlvo", rlvo);
		request.setAttribute("hplist", list2);
		request.setAttribute("rplist", list3);
		
		System.out.println("ModelAndView...생성...");		
		return new ModelAndView("showRecipe.jsp");
	}

}
