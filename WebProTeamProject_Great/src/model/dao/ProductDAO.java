package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.vo.ProductVO;
import query.ShowQuery;
import query.StringQuery;

public class ProductDAO {
	DataSource ds;
	
	private static ProductDAO dao= new ProductDAO();
	
	private ProductDAO() {
		ds=DataSourceManager.getInstance().getConnection();
	}
	
	public static ProductDAO getInstance() {
		
		return dao;
	}
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException{
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}
	
	
	//상품등록
	public void productWrite(ProductVO vo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.INSERT_PRODUCT);
			
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPrice());
			ps.setString(3, vo.getOrigin());
			ps.setString(4, vo.getImg_urls());
			ps.setString(5, vo.getContent());
			ps.setString(6, vo.getType());
			ps.setString(7, vo.getBrand());
			ps.setInt(8, vo.getSales_volume());
			ps.setString(9, vo.getRecommend());
			
			int row = ps.executeUpdate();
			System.out.println(row+" row insert product ok....");
				
			
		}finally{
			closeAll(ps, conn);
		}
	}
	//상품삭제
	public void deleteProduct(String name) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.DELETE_PRODUCT);
			ps.setString(1, name);
			int row = ps.executeUpdate();
			System.out.println(row+ "ROW DELETE OK!!! ");
		}finally {
			closeAll(ps, conn);
		}
	}
	//상품 수정
	public void updateProduct(ProductVO vo)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.UPDATE_PRODUCT);			
	
			ps.setInt(1, vo.getPrice());
			ps.setString(2, vo.getOrigin());
			ps.setString(3, vo.getImg_urls());
			ps.setString(4, vo.getContent());
			ps.setString(5, vo.getType());
			ps.setString(6, vo.getBrand());
			ps.setString(7, vo.getRecommend());
			ps.setInt(8, vo.getSales_volume());
			ps.setString(9, vo.getName());
			
			int row=  ps.executeUpdate();
			System.out.println(row+" ROW UPDATE OK!!!");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	
	//--------------------------------------------------------------------------------------------------
	//----------------------------------------show
	

	   public ArrayList<ProductVO> showProductHot() throws SQLException {
	      Connection conn = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      ArrayList<ProductVO> list = new ArrayList<ProductVO>();
	      try {
	         conn = getConnection();
	         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWHOTPRODUCT);
	         rs = ps.executeQuery();
	         while (rs.next()) {
	            list.add(new ProductVO(rs.getString("name"), rs.getInt("price"), rs.getString("origin"),
	                  rs.getString("img_urls"), rs.getString("content"), rs.getString("type"), rs.getString("brand"),
	                  rs.getInt("sales_volume"), rs.getString("recommend"), rs.getString("amount")));
	         }
	      } finally {
	         closeAll(rs, ps, conn);
	      }
	      return list;
	   }

	   public ArrayList<ProductVO> showProductRecommend() throws SQLException {
	      Connection conn = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      ArrayList<ProductVO> list = new ArrayList<ProductVO>();
	      try {
	         conn = getConnection();
	         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWRECOMMENDPRODUCT);
	         rs = ps.executeQuery();
	         while (rs.next()) {
	            list.add(new ProductVO(rs.getString("name"), rs.getInt("price"), rs.getString("origin"),
	                  rs.getString("img_urls"), rs.getString("content"), rs.getString("type"), rs.getString("brand"),
	                  rs.getInt("sales_volume"), rs.getString("recommend"), rs.getString("amount")));
	         }
	      } finally {
	         closeAll(rs, ps, conn);
	      }
	      return list;
	   }
	   
	   public ArrayList<ProductVO> showIngredientsProduct(int no) throws SQLException{
	      Connection conn = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      ArrayList<ProductVO> list = new ArrayList<ProductVO>();
	      try {
	         conn = getConnection();
	         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWINGREDIENTSPRODUCT);
	         ps.setInt(1, no);
	         rs = ps.executeQuery();
	         while (rs.next()) {
	            list.add(new ProductVO(rs.getString("name"), rs.getInt("price"), rs.getString("origin"),
	                  rs.getString("img_urls"), rs.getString("content"), rs.getString("type"), rs.getString("brand"),
	                  rs.getInt("sales_volume"), rs.getString("recommend"), rs.getString("amount")));
	         }
	      } finally {
	         closeAll(rs, ps, conn);
	      }
	      return list;
	   }
	   
	
	
	
}
