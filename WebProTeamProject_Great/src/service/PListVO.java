package service;

import java.util.ArrayList;

import model.dao.PagingBean;
import model.vo.ProductVO;

public class PListVO {
	private PagingBean pagingBean;
	ArrayList<ProductVO> list;
	public PListVO(PagingBean pagingBean, ArrayList<ProductVO> list) {
		super();
		this.pagingBean = pagingBean;
		this.list = list;
	}
	public PListVO() {
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
	public ArrayList<ProductVO> getList() {
		return list;
	}
	public void setList(ArrayList<ProductVO> list) {
		this.list = list;
	}
	
	
}
