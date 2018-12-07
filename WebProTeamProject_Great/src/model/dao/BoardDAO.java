package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.vo.BoardVO;
import model.vo.ReviewVO;
import query.ReviewStringQuery;
import query.StringQuery;

public class BoardDAO {
DataSource ds;
	
	private static BoardDAO dao= new BoardDAO();
	
	private BoardDAO() {
		ds=DataSourceManager.getInstance().getConnection();
	}
	
	public static BoardDAO getInstance() {
		
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
	
	

	public int writeReview(ReviewVO rvo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int num=0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(ReviewStringQuery.INSERT_REVIEW);
			System.out.println(ReviewStringQuery.INSERT_REVIEW);
			ps.setString(1, rvo.getWriter());
			ps.setString(2, rvo.getImg_urls());
			
			ps.setString(3, rvo.getContent());
			ps.setString(4, rvo.getTitle());
			ps.setString(5, rvo.getAbout());
			int row = ps.executeUpdate();
			System.out.println(row+" row insert posting ok....");
			System.out.println("dao CURRENT_NO...before...."+rvo.getNo());//x
		
			ps = conn.prepareStatement(ReviewStringQuery.CURRENT_NO);
			System.out.println(ReviewStringQuery.CURRENT_NO);
			rs = ps.executeQuery();
			if(rs.next()) 
				num =rs.getInt(1);
			System.out.println("dao CURRENT_NO...after...."+num);//o
		}finally{
			closeAll(rs, ps, conn);
		}
		return num;
	}
	
	
	
	
	public void deleteReview(int no) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.DELETE_REVIEW);
			ps.setInt(1, no);
			int row = ps.executeUpdate();
			System.out.println(row+ "ROW DELETE OK!!! ");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	public void updateReview(ReviewVO vo)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.UPDATE_REVIEW);			
			
			ps.setString(1, vo.getWriter());
			ps.setString(2, vo.getImg_urls());
		
			ps.setString(3, vo.getContent());
			ps.setInt(4, vo.getNo());
			
			int row=  ps.executeUpdate();
			System.out.println(row+" ROW UPDATE OK!!!");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	public ReviewVO getReviewByNo(int no) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReviewVO rvo =null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(ReviewStringQuery.GET_REVIEW_BY_NO);
			System.out.println(ReviewStringQuery.GET_REVIEW_BY_NO);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) 
				rvo = new ReviewVO(rs.getInt("no"), rs.getString("title"), rs.getString("writer"), rs.getString("img_urls"),
						rs.getString("REGISTER_DATE"), rs.getString("content"),rs.getString("about"));
			System.out.println("dao CURRENT_NO...after...."+rvo);//o
		}finally{
			closeAll(rs, ps, conn);
		}
		return rvo;
	}
	
	public int getTotalReviewCount() throws SQLException{
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs=  null;
		int count=-1;
		try{
			conn=  getConnection();
			ps = conn.prepareStatement(ReviewStringQuery.REVIEW_COUNT);
			rs = ps.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		}finally{
			closeAll(rs, ps, conn);
		}
		return count;
	}
	public int getAboutReviewCount(String about) throws SQLException{
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs=  null;
		int count=-1;
		try{
			conn=  getConnection();
			ps = conn.prepareStatement(ReviewStringQuery.REVIEW_ABOUT_COUNT);
			ps.setString(1,about);
			rs = ps.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		}finally{
			closeAll(rs, ps, conn);
		}
		return count;
	}
	public ArrayList<ReviewVO> showReview(int pn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		try {
			conn=  getConnection();
			ps = conn.prepareStatement(ReviewStringQuery.REVIEW_PAGE_LIST);
			System.out.println(ReviewStringQuery.REVIEW_PAGE_LIST);
			ps.setInt(1, pn);
			rs = ps.executeQuery();
			System.out.println("1!!");
		

			while(rs.next()) {
				list.add(new ReviewVO(rs.getInt("no"), 
							rs.getString("title"), rs.getString("writer"),  
									 rs.getString("img_urls"), 
									 rs.getString("register_date"), 
									 rs.getString("content"),
									 rs.getString("about")));
									 
			}
			System.out.println(list);
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	public ArrayList<ReviewVO> showReview(int pn , String about) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		try {
			conn=  getConnection();
			ps = conn.prepareStatement(ReviewStringQuery.REVIEW_ABOUT_LIST);
			System.out.println(ReviewStringQuery.REVIEW_ABOUT_LIST);
			ps.setInt(1, pn);
			ps.setString(2,about);
			rs = ps.executeQuery();
			System.out.println("1!!");
		

			while(rs.next()) {
				list.add(new ReviewVO(rs.getInt("no"), 
							rs.getString("title"), rs.getString("writer"),  
									 rs.getString("img_urls"), 
									 rs.getString("register_date"), 
									 rs.getString("content"),
									 rs.getString("about")));
									 
			}
			System.out.println(list);
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	
	public int getTotalPostingCount() throws SQLException{
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs=  null;
		int count=-1;
		try{
			conn=  getConnection();
			ps = conn.prepareStatement(StringQuery.TOTAL_NOTICE_COUNT);
			System.out.println(StringQuery.TOTAL_NOTICE_COUNT);
			rs = ps.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		}finally{
			closeAll(rs, ps, conn);
		}
		return count;
	}
	
	public ArrayList<BoardVO> showNotice(int pageNo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn=  getConnection();
			ps = conn.prepareStatement(StringQuery.PAGE_NOTICE_LIST);
			System.out.println(StringQuery.PAGE_NOTICE_LIST);
			ps.setInt(1, pageNo);
			rs = ps.executeQuery();
			System.out.println("1!!");
			
			while(rs.next()) {
				list.add(new BoardVO(rs.getInt("no"), 
									 rs.getString("writer"),  
									 rs.getString("register_date"), 
									 rs.getString("title"),
									 3,
									 rs.getString("content")));
									 
			}
			System.out.println(list);
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	public ArrayList<BoardVO> showMainNotice() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn=  getConnection();
			ps = conn.prepareStatement(StringQuery.MAIN_NOTICE_LIST);
			System.out.println(StringQuery.MAIN_NOTICE_LIST);
			
			rs = ps.executeQuery();
			System.out.println("1!!");
			
			while(rs.next()) {
					String str = rs.getString("title");
				if(str.length()>14)
					str=str.substring(0,13)+"...";
				list.add(new BoardVO(rs.getInt("no"), 
									 rs.getString("writer"),  
									 rs.getString("register_date"), 
									 str,
									 3,
									 rs.getString("content")));
									 	System.out.println(str);
			}
			System.out.println(list);
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	public void updateHits(int no, int hits)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.UPDATE_HITS);
			ps.setInt(1, hits);
			ps.setInt(2, no);
			int row = ps.executeUpdate();
			System.out.println(row+"ROW 조회");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	public BoardVO getNoticeByNo(int no) throws SQLException{
		BoardVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn=  getConnection();
			ps = conn.prepareStatement(StringQuery.SELECT_NOTICE);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new BoardVO(no, 
								 rs.getString("writer"),  
								 rs.getString("register_date"), 
								 rs.getString("title"),
								 rs.getInt("hits"),
								 rs.getString("content"));				
			}
		}finally{
			closeAll(rs,ps, conn);
		}
		return vo;
	}//

	
}
