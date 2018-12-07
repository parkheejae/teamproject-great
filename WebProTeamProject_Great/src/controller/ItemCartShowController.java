package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;
import model.vo.CartVO;

public class ItemCartShowController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		 CartBiz cartBiz=  new CartBiz();
		 ArrayList<CartVO> cartList=cartBiz.getCartList(request);
		 
		 System.out.println("ItemCartShow :: " + cartList);
		 if(cartList!=null) {
			 
			 int sumMoney = 0;
				for(CartVO c : cartList) {
					int money = c.getPrice()*c.getQuantity();
					sumMoney += money;
				}
				//���⼭�� �ٷ� ��� �������� ����...forward������� ����...request�� ���ε�
				request.setAttribute("sumMoney", sumMoney);
				request.setAttribute("cartList", cartList);
				request.setAttribute("cartSize", cartList.size());
				System.out.println("�ջ� ����"+sumMoney);
				
		 }else {
			 request.setAttribute("cartSize", 0);
		 }
		 	ModelAndView mv = new ModelAndView();
			mv.setPath("productCartList.jsp");		
			return mv;
	}
}
