package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.vo.CartVO;
import query.StringQuery;

public class SalesDAO {
	DataSource ds;
	private static SalesDAO saledao= new SalesDAO();
	private SalesDAO() {
		ds=DataSourceManager.getInstance().getConnection();
	}
	public static SalesDAO getInstance() {
		return saledao;
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
	// 장바구니에서 구매시 장바구니는 delete, 구매페이지는 insert
	public void purchaseProduct(CartVO cart) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn=getConnection();
			ps = conn.prepareStatement(StringQuery.INSERT_PURCHASE);
			System.out.println(StringQuery.INSERT_PURCHASE);
			ps.setString(1, cart.getName());
			ps.setInt(2, cart.getPrice());
			ps.setInt(3, cart.getQuantity());
			ps.setString(4, cart.getImg_urls());
			
			int row = ps.executeUpdate();
			System.out.println(row + " 개의 항목이 구매되었습니다.");
			
		}finally{
			closeAll(ps, conn);
		}
	}
	
	public CartVO searchProduct(String name) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CartVO vo = null;
		try{
			conn=getConnection();
			ps = conn.prepareStatement(StringQuery.SEARCH_CART);
			System.out.println(StringQuery.SEARCH_CART);
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new CartVO(rs.getString("userId"), rs.getString("name"),
						rs.getInt("price"), rs.getInt("quantity"), rs.getString("img_urls"));
			}
			System.out.println(vo+"11");
		}finally{
			closeAll(rs, ps, conn);
		}
		
		return vo;
	}
	
}
