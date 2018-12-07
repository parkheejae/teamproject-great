package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.RecipeDAO;

public class DeleteRecipeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DeleteRecipeController");
		
		int no = Integer.parseInt(request.getParameter("no"));
		RecipeDAO.getInstance().deleteRecipe(no);
		
		
		return new ModelAndView("serchmyrecipe.do");
	}

}
