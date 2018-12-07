package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cartbiz.CartBiz;
import model.vo.CartVO;
import model.vo.MemberVO;

public class ItemCartQtyUpController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String realName = request.getParameter("name");
		HttpSession session = request.getSession();
		String id = ((MemberVO)session.getAttribute("login")).getId();

		CartBiz cartBiz = new CartBiz();
		ArrayList<CartVO> cartList = cartBiz.getCartList(request);
		cartBiz.upCartQty(cartList,id, realName);
		
		ModelAndView mv = new ModelAndView();
		mv.setPath("ItemCart.do");
		mv.setRedirect(true);
		return mv;
	}
}
