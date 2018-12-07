package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowDao;
import model.vo.ProductVO;
import model.vo.RecipeVO;


public class ShowProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		ProductVO pvo = ShowDao.getInstance().showProduct(name);
		request.setAttribute("pvo", pvo);
		
		
		ModelAndView mv = new ModelAndView();
		System.out.println("ModelAndView...»ý¼º...");
		mv.setPath("productdeatails.jsp");
		return mv;
	}

}
