package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cartbiz.CartBiz;
import dao.ShowDao;
import model.vo.CartVO;
import model.vo.MemberVO;
import model.vo.ProductVO;

public class ItemCartAController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String confirm = request.getParameter("confirm");
		System.out.println(confirm);
		 /*String[ ] names=request.getParameterValues("delete");*/
		System.out.println(name);
		CartBiz cartBiz=  new CartBiz();
		
		ArrayList<CartVO> cartList = cartBiz.getCartList(request);
		ProductVO product = ShowDao.getInstance().showProduct(name);
		System.out.println(product);
		cartBiz.addCart(request,product);
		 
		//CartVO vo =  SalesDAO.getInstance().searchProduct(name);
		//System.out.println(vo);
		//SalesDAO.getInstance().purchaseProduct(vo);
		
		
		ModelAndView mv = new ModelAndView();
		
		if(confirm.equals("true"))mv.setPath("ItemCart.do");
		else mv.setPath("showProductDetail.do?name="+name);
		
		System.out.println(mv.getPath());
		return mv;
	}

}
