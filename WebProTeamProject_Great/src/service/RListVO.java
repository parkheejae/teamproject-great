package service;

import java.util.ArrayList;

import model.dao.PagingBean;
import model.vo.RecipeVO;

public class RListVO {
	private PagingBean pagingBean;
	ArrayList<RecipeVO> list;
	public RListVO(PagingBean pagingBean, ArrayList<RecipeVO> list) {
		super();
		this.pagingBean = pagingBean;
		this.list = list;
	}
	public RListVO() {
		super();
	}
	
	@Override
	public String toString() {
		return "ListVO [pagingBean=" + pagingBean + ", list=" + list + "]";
	}
	public PagingBean getPagingBean() {
		return pagingBean;
	}
	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}
	public ArrayList<RecipeVO> getList() {
		return list;
	}
	public void setList(ArrayList<RecipeVO> list) {
		this.list = list;
	}
	
	
}
