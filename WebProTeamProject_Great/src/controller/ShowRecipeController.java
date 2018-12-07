package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.RecipeDAO;
import model.vo.DiscriptVO;
import model.vo.ProductVO;
import model.vo.RecipeVO;
import service.BoardService;
import service.ReviewListVO;


public class ShowRecipeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("왜안대"+num);
		RecipeVO rvo = RecipeDAO.getInstance().showRecipe(num);
		
		ArrayList<RecipeVO> llist = RecipeDAO.getInstance().showRelatedRecipe(num);
		ArrayList<ProductVO> plist = RecipeDAO.getInstance().showRelatedProduct(rvo.getMain_ingredients());
				System.out.println("여긴가");
		String[] contents =  rvo.getContent().split("///");
		ArrayList<DiscriptVO>  dlist = new ArrayList<DiscriptVO>();
		for(String str : contents) {
			System.out.println(str);
			String[] strs = str.split("/_/");
				if(strs.length>1) {
					dlist.add(new DiscriptVO(strs[0],strs[1]));
					System.out.println(strs[0]);
				}else {
					dlist.add(new DiscriptVO(str));
				}

		}
		
		String pageNo ="1";
		pageNo= request.getParameter("page");
		System.out.println(pageNo+ " What page is it? ");
		
		ReviewListVO lvo = BoardService.getInstance().showReview(pageNo,num+"");
		
		request.setAttribute("lvo", lvo);
		
		
		request.setAttribute("rvo", rvo);
		
		request.setAttribute("plist", plist);
		request.setAttribute("llist", llist);
		request.setAttribute("dlist", dlist);
		ModelAndView mv = new ModelAndView();
		System.out.println("ModelAndView...생성...");
		mv.setPath("recipedetail.jsp");
		return mv;
	}

}
