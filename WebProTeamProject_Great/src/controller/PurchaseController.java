package controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cartbiz.CartBiz;
import model.dao.PurchaseInfoDAO;
import model.vo.CartVO;
import model.vo.MemberVO;
import model.vo.PurchaseInfoVO;

public class PurchaseController implements Controller {

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String[] names = request.getParameterValues("delete");
      //String[] product=request.getParameterValues("name");      
      
      for(String c : names) {
         System.out.println("어떤거 고름??  :: " + c);
         System.out.println(c+"를 골랐어 c바");
      }
      CartBiz cartBiz=  new CartBiz();
      
      ArrayList<CartVO> cartList=cartBiz.getCartList(request);
      PurchaseInfoVO pvo=null;
      //PurchaseInfoVO svo=new PurchaseInfoVO();
      HttpSession session = request.getSession();
		String id = ((MemberVO)session.getAttribute("login")).getId();
		String str="";
      //이건 CartVO 가져와서 PurchaseVO에 맵핑하는 과정이다.
		int i=0;
      for(CartVO c : cartList) {
    	 
         System.out.println("Purchase :: " + c);
         //값 DB 저장  -- 잘됨
         if(c.getUserId().equals(id)) {
         pvo= PurchaseInfoDAO.getInstance().PurchaseInfoInsert(c);
         //svo= PurchaseInfoDAO.getInstance().showPurchaseInfo();
         if(i>0)str+=" , ";
         str+=pvo.getProname();
         i++;
         }
         System.out.println("저장한 data :: "+ pvo);
         
         
      }
      
      //장바구니에서 삭제하는거고
       for(String name : names) {
            Iterator<CartVO> iter = cartList.iterator();
            while(iter.hasNext()) {
               if(iter.next().getName().equals(name))
                  iter.remove();
            }
       }
      
       request.setAttribute("purchaseListname", str);
       
      
      System.out.println("ModelAndView...생성...");
      ModelAndView mv = new ModelAndView();
      mv.setPath("purchase_ok.jsp");
      //mv.setRedirect(true);
      return mv;
   }

}