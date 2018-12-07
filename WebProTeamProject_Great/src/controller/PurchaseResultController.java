package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.PurchaseInfoDAO;
import model.vo.MemberVO;
import model.vo.PurchaseInfoVO;

public class PurchaseResultController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String id = ((MemberVO)session.getAttribute("login")).getId();
		
		ArrayList<PurchaseInfoVO> purchaseList=new ArrayList<PurchaseInfoVO>();
		purchaseList= PurchaseInfoDAO.getInstance().showPurchaseInfo(id);
		System.out.println("불러온 data :: "+ purchaseList);
		request.setAttribute("purchaseInfo", purchaseList);
	      
		 System.out.println("ModelAndView...생성...");
	      ModelAndView mv = new ModelAndView();
	      mv.setPath("purchase_History.jsp");
	      //mv.setRedirect(true);
	      return mv;
	}

}
