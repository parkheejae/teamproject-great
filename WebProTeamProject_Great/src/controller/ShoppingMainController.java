package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductDAO;
import model.vo.ProductVO;

public class ShoppingMainController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ProductVO> hotList= ProductDAO.getInstance().showProductHot();
		ArrayList<ProductVO> newList = ProductDAO.getInstance().showProductRecommend();
										
			
		
		
		
		return null;
	}

	
	
	
}
