package service;

import java.util.ArrayList;

import dao.SearchDao;
import dao.ShowDao;
import model.dao.PagingBean;
import model.vo.ProductVO;
import model.vo.RecipeVO;

public class RPService {
	private ShowDao dao;
	private static RPService service = new RPService();
	private RPService() {
		dao = ShowDao.getInstance();
	}
	public static RPService getInstance() {
		return service;
	}
	public PListVO showTypeProduct(String type,String pageNo) throws Exception {
		int pn =1;
		
        if(pageNo !=null) pn = Integer.parseInt(pageNo);
		
		ArrayList<ProductVO> list = dao.getProductList(type,pn);
		int total = dao.getTotalProductCount(type);
		PagingBean pb = new PagingBean(total,pn);
		
		return new PListVO(pb,list);
	}
	
	public PListVO showProduct(String pageNo) throws Exception {
		int pn =1;
		
        if(pageNo !=null) pn = Integer.parseInt(pageNo);
		
		ArrayList<ProductVO> list = dao.getProductList(pn);
		int total = dao.getTotalProductCount();
		PagingBean pb = new PagingBean(total,pn);
		
		return new PListVO(pb,list);
	}
	
	public RListVO showRecipe(String pageNo) throws Exception {
		int pn =1;
		
        if(pageNo !=null) pn = Integer.parseInt(pageNo);
		
		ArrayList<RecipeVO> list = dao.getRecipeList(pn);
		int total = dao.getTotalRecipeCount();
		PagingBean pb = new PagingBean(total,pn);
		
		return new RListVO(pb,list);
	}
	
	public RListVO searchrecipe(ArrayList<String> words , String pageNo) throws Exception {
		int pn = 1;
		
        if(pageNo !=null) pn = Integer.parseInt(pageNo);
		
		ArrayList<RecipeVO> list = SearchDao.getInstance().searchRecipe(words, pn);
		int total = SearchDao.getInstance().countSearchRecipe(words, pn);
		PagingBean pb = new PagingBean(total,pn);
		
		return new RListVO(pb,list);
	}
	
	public RListVO searchRecipeByWriter(String writer , String pageNo) throws Exception {
		int pn =1;
		
        if(pageNo !=null) pn = Integer.parseInt(pageNo);
		
		ArrayList<RecipeVO> list = SearchDao.getInstance().searchRecipeByWriter(writer,pn);
		int total = SearchDao.getInstance().countSearchRecipeByWriter(writer, pn);
		PagingBean pb = new PagingBean(total,pn);
		
		return new RListVO(pb,list);
	}
	
	public PListVO searchProduct(ArrayList<String> words , String pageNo) throws Exception {
		int pn =1;
		
        if(pageNo !=null) pn = Integer.parseInt(pageNo);
		
		ArrayList<ProductVO> list = SearchDao.getInstance().searchProduct(words, pn);
		int total = SearchDao.getInstance().countSearchProduct(words, pn);
		PagingBean pb = new PagingBean(total,pn);
		
		return new PListVO(pb,list);
	}
}
