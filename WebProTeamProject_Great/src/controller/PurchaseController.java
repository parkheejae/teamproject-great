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
         System.out.println("��� ��??  :: " + c);
         System.out.println(c+"�� ����� c��");
      }
      CartBiz cartBiz=  new CartBiz();
      
      ArrayList<CartVO> cartList=cartBiz.getCartList(request);
      PurchaseInfoVO pvo=null;
      //PurchaseInfoVO svo=new PurchaseInfoVO();
      HttpSession session = request.getSession();
		String id = ((MemberVO)session.getAttribute("login")).getId();
		String str="";
      //�̰� CartVO �����ͼ� PurchaseVO�� �����ϴ� �����̴�.
		int i=0;
      for(CartVO c : cartList) {
    	 
         System.out.println("Purchase :: " + c);
         //�� DB ����  -- �ߵ�
         if(c.getUserId().equals(id)) {
         pvo= PurchaseInfoDAO.getInstance().PurchaseInfoInsert(c);
         //svo= PurchaseInfoDAO.getInstance().showPurchaseInfo();
         if(i>0)str+=" , ";
         str+=pvo.getProname();
         i++;
         }
         System.out.println("������ data :: "+ pvo);
         
         
      }
      
      //��ٱ��Ͽ��� �����ϴ°Ű�
       for(String name : names) {
            Iterator<CartVO> iter = cartList.iterator();
            while(iter.hasNext()) {
               if(iter.next().getName().equals(name))
                  iter.remove();
            }
       }
      
       request.setAttribute("purchaseListname", str);
       
      
      System.out.println("ModelAndView...����...");
      ModelAndView mv = new ModelAndView();
      mv.setPath("purchase_ok.jsp");
      //mv.setRedirect(true);
      return mv;
   }

}