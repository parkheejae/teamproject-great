package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.dao.DataSourceManager;
import model.vo.MemberVO;
import query.StringQuery;

public class MemberDAO {
	DataSource ds;
	private static MemberDAO dao= new MemberDAO();
	private MemberDAO() {
		ds=DataSourceManager.getInstance().getConnection();
	}
	public static MemberDAO getInstance() {
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
	//중복가입 유무확인
	public boolean idExist(String id) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean exist = false;
		try{
			conn=getConnection();
			ps = conn.prepareStatement(StringQuery.SELECT_CHECK_ID);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				if(rs.getInt(1)==1){
					exist=true;
				}
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return exist;
	}
	//회원가입
	public void registerMember(MemberVO mvo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//id,password,name,email,birthday,address
			conn=getConnection();
			ps = conn.prepareStatement(StringQuery.INSERT_MEMBER);
			System.out.println(StringQuery.INSERT_MEMBER);
			ps.setString(1, mvo.getId());
			ps.setString(2, mvo.getPassword());
			ps.setString(3, mvo.getName());
			ps.setString(4, mvo.getEmail());
			ps.setString(5, mvo.getBirthday());
			ps.setString(6, mvo.getAddress());
			if(ps.executeUpdate()!=0){
				System.out.println(mvo.getName()+" 님 회원가입 성공");
			}
		}finally{
			closeAll(ps, conn);
		}
	}
	//로그인
	public MemberVO login(String id, String password) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO mvo = null;
		try{
			conn=getConnection();
			ps = conn.prepareStatement(StringQuery.LOGIN_MEMBER);
			System.out.println(StringQuery.LOGIN_MEMBER);
			ps.setString(1, id);
			ps.setString(2, password);
			System.out.println(id+password+"여긴 왔냐!!!!!");
			rs=ps.executeQuery();
			System.out.println(rs);
			if(rs.next()){
				mvo = new MemberVO(rs.getString("id"),
									rs.getString("password")); 
				System.out.println(mvo);
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return mvo;
	}
	
	//회원검색
	public MemberVO searchMember(String id) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		
		try{
			conn=getConnection();
			ps = conn.prepareStatement(StringQuery.SEARCH_MEMBER);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				vo = new MemberVO(rs.getString("id"),rs.getString("password"));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	//아이디 찾기
	public String searchID(String name, String ssn) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = "";
		try{
			conn=getConnection();
			ps = conn.prepareStatement(StringQuery.SELECT_SEARCH_ID);
			ps.setString(1, name);
			ps.setString(2, ssn);
			rs = ps.executeQuery();
			if(rs.next()){
				id = rs.getString("id");
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return id;
	}
	
	//비밀번호 검색
	public String searchPass(String id,String name,String ssn) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String password = null;
		try{
			conn=getConnection();
			ps = conn.prepareStatement(StringQuery.SELECT_SEARCH_PASSWORD);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, ssn);
			rs = ps.executeQuery();
			if(rs.next()){
				password = rs.getString("password");
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return password;
	}
	public static void main(String[] args) throws Exception {
		MemberVO vo= new MemberVO();
		MemberDAO.getInstance().login("kh4331","123456");
		System.out.println(vo);			 
	}
}
