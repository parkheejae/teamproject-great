package controller;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductDAO;
import model.vo.ProductVO;
import service.PListVO;
import service.RListVO;
import service.RPService;

public class SearchController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String text = request.getParameter("search");
		request.setAttribute("search", text);
		String page = request.getParameter("page");
		
		System.out.println("page :: " + page);
		System.out.println("text :: " + text);
		ArrayList<String> array = new ArrayList<String>();
		if(text != null) {
			text = text.replace(",", " ");
			
			System.out.println("text :: "+text);
			StringTokenizer st = new StringTokenizer(text, " ");	// 공백으로 단어 구분
			
			while(st.hasMoreTokens()){
				array.add(st.nextToken());
			}
		}else {
			System.out.println("널이니까 바로 일루와");
		}

		RListVO rlist = RPService.getInstance().searchrecipe(array, page);
		PListVO plist =  RPService.getInstance().searchProduct(array, page);
		
		ArrayList<ProductVO> list3 = ProductDAO.getInstance().showProductHot();
		ArrayList<ProductVO> list4 = ProductDAO.getInstance().showProductRecommend();

		request.setAttribute("HotPlist", list3);
		request.setAttribute("RecommendPlist", list4);
		
		System.out.println(rlist);
		
		request.setAttribute("rlist", rlist);
		request.setAttribute("plist", plist);	
		return new ModelAndView("searchRecipeResult.jsp");
	}
}
