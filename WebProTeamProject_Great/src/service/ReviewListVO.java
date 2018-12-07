package service;

import java.util.ArrayList;

import model.dao.PagingBean;
import model.vo.BoardVO;
import model.vo.ReviewVO;

public class ReviewListVO {
	private PagingBean pagingBean;
	ArrayList<ReviewVO> list;
	
	public ReviewListVO(PagingBean pagingBean, ArrayList<ReviewVO> list) {
		super();
		this.pagingBean = pagingBean;
		this.list = list;
	}
	public ReviewListVO() {
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
	public ArrayList<ReviewVO> getList() {
		return list;
	}
	public void setList(ArrayList<ReviewVO> list) {
		this.list = list;
	}
	
	
}
