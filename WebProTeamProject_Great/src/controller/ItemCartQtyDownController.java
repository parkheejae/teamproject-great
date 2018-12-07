package controller;

import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cartbiz.CartBiz;
import model.vo.CartVO;
import model.vo.MemberVO;

public class ItemCartQtyDownController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String realName = URLDecoder.decode( name , "UTF-8" );
		CartBiz cartBiz = new CartBiz();
		HttpSession session = request.getSession();
		String id = ((MemberVO)session.getAttribute("login")).getId();
		ArrayList<CartVO> cartList = cartBiz.getCartList(request);
		cartBiz.downCartQty(cartList,id, realName);
		
		System.out.println("====================="+realName);
		ModelAndView mv = new ModelAndView();
		mv.setPath("ItemCart.do");
		mv.setRedirect(true);
		return mv;
	}

}
