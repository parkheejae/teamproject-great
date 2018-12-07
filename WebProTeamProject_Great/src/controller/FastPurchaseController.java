package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ShowDao;
import model.dao.PurchaseInfoDAO;
import model.vo.CartVO;
import model.vo.MemberVO;
import model.vo.ProductVO;
import model.vo.PurchaseInfoVO;

public class FastPurchaseController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		ProductVO product=ShowDao.getInstance().showProduct(name); 
		 HttpSession session = request.getSession();
			String id = ((MemberVO)session.getAttribute("login")).getId();
			CartVO cartVO = new CartVO(id, product.getName(),product.getPrice(),1,product.getImg_urls());
			
			 PurchaseInfoVO pvo = PurchaseInfoDAO.getInstance().PurchaseInfoInsert(cartVO);
			 request.setAttribute("purchaseListname", pvo.getProname());
			 System.out.println("ModelAndView...»ý¼º...");
		      ModelAndView mv = new ModelAndView();
		      mv.setPath("purchase_ok.jsp");
		      //mv.setRedirect(true);
		      return mv;
		   }
}
