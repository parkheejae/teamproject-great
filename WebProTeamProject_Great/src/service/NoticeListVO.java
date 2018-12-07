package service;

import java.util.ArrayList;

import model.dao.PagingBean;
import model.vo.BoardVO;

public class NoticeListVO {
	private PagingBean pagingBean;
	ArrayList<BoardVO> list;
	public NoticeListVO(PagingBean pagingBean, ArrayList<BoardVO> list) {
		super();
		this.pagingBean = pagingBean;
		this.list = list;
	}
	public NoticeListVO() {
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
	public ArrayList<BoardVO> getList() {
		return list;
	}
	public void setList(ArrayList<BoardVO> list) {
		this.list = list;
	}
	
	
}
