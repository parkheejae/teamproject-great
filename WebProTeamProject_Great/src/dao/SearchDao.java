package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.OracleInfo;
import model.dao.CommonConstants;

import model.vo.ProductVO;
import model.vo.RecipeVO;
import query.ShowQuery;

public class SearchDao {

	private String url;
	private String user;
	private String pass;
	
	
	
	static private SearchDao dao = new SearchDao();
	private SearchDao( ) {								
				url=OracleInfo.URL;
				user=OracleInfo.USER;
				pass=OracleInfo.PASS;
	};
	 
	public static SearchDao getInstance() {
		return dao;
	}
	
	

	private Connection getConnect() throws SQLException {

		Connection conn = DriverManager.getConnection(url, user, pass);
		System.out.println("db connection....");
		return conn;
	}

	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(ps, conn);
	}
	
	public ArrayList<RecipeVO> searchRecipe(String[] words, int page) throws SQLException {
		System.out.println("searchrecipe words");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		try {
			conn= getConnect();
			for(int i=0; i <= words.length-1;i++) {
				String query = "SELECT no, name, img_urls, main_ingredients, writer,register_date, type, hits FROM";
				query += "(SELECT no, name, img_urls, main_ingredients ,writer,register_date, type, hits, ceil(rownum/6) AS page FROM ";
				
				if(words[i]!=" "&i==0) {
					query += "recipe) WHERE name LIKE '%"+words[i]+"%' order by hits desc";
					ps = conn.prepareStatement(query);}
					
				else if(words[i]!=" "&i!=0) {
					query += "or name LIKE '%"+words[i]+"%' order by hits desc";
					ps = conn.prepareStatement(query);}
				else {
					query += "(SELECT no, name, img_urls, main_ingredients ,writer,register_date, type, hits FROM recipe order by no desc)) where page=?";
					ps = conn.prepareStatement(query);
					ps.setInt(1, page);
				}
				System.out.println(query);
				
				
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(new RecipeVO(rs.getInt("no"),rs.getString("name"),rs.getString("img_urls"),rs.getString("main_ingredients"),
							rs.getString("writer"), rs.getString("register_date"),rs.getString("type"),rs.getInt("hits")));
				}
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		System.out.println("return list");
		return list;
	}
	
	public int countSearchRecipe(String[] words, int page) throws SQLException {
		System.out.println("searchrecipe words");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;
		
		try {
			conn= getConnect();
			for(int i=0; i <= words.length-1;i++) {
				String query = "SELECT count(-1) FROM";
				query += "(SELECT no, name, img_urls, main_ingredients ,writer,register_date, type, hits, ceil(rownum/6) AS page FROM ";
				
				if(words[i]!=" "&i==0) {
					query += "recipe) WHERE name LIKE '%"+words[i]+"%' order by hits desc";
					ps = conn.prepareStatement(query);}
					
				else if(words[i]!=" "&i!=0) {
					query += "or name LIKE '%"+words[i]+"%' order by hits desc";
					ps = conn.prepareStatement(query);}
				else {
					query += "(SELECT no, name, img_urls, main_ingredients ,writer,register_date, type, hits FROM recipe order by no desc))";
					ps = conn.prepareStatement(query);
					
				}
				System.out.println(query);
				
				
				rs = ps.executeQuery();
				if(rs.next())count += rs.getInt(1);
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		System.out.println("return recipe count");
		return count;
	}
	public ArrayList<RecipeVO> searchRecipeByWriter(String writer ,  int page) throws SQLException {
		System.out.println("searchrecipe writer");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		try {
				conn= getConnect();
			
				String query = "SELECT no, name, img_urls,main_ingredients, register_date,writer, type, hits FROM ";
				query += "(SELECT no, name, img_urls,main_ingredients, register_date,writer, type, hits, ceil(rownum/6) AS page FROM";
				query += "(SELECT no, name, img_urls,main_ingredients, register_date,writer, type, hits FROM recipe WHERE writer = '"+writer+"' ORDER BY no DESC)) where page=?";
				
				System.out.println(query);
				ps = conn.prepareStatement(query);
				ps.setInt(1, page);
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(new RecipeVO(rs.getInt("no"),rs.getString("name"),rs.getString("img_urls"),rs.getString("main_ingredients"),
							rs.getString("writer"), rs.getString("register_date"),rs.getString("type"),rs.getInt("hits")));
				
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	public int countSearchRecipeByWriter(String writer ,  int page) throws SQLException {
		System.out.println("countrecipe writer");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int count=0;
		try {
				conn= getConnect();
			
				String query = "SELECT count(-1) FROM ";
				query += "(SELECT no, name, img_urls,main_ingredients, register_date, type, hits, ceil(rownum/6) AS page FROM";
				query += "(SELECT no, name, img_urls,main_ingredients, register_date, type, hits FROM recipe WHERE writer = '"+writer+"' ORDER BY no DESC))";
				
				System.out.println(query);
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				if(rs.next()) count += rs.getInt(1);
				
			
		}finally {
			closeAll(rs, ps, conn);
		}
		return count;
	}
	public ArrayList<ProductVO> searchProduct(String[] words , int page) throws SQLException {
		System.out.println("searchproduct words");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		
		try {
			conn= getConnect();
			String query = "SELECT name, price, img_urls, type FROM  ";
			query += "(SELECT name, price, img_urls, type,sales_volume, ceil(rownum/5) AS page FROM ";
			for(int i=0; i <= words.length-1;i++) {
					if(words[i]!=" "&i==0) {
						query += "product) WHERE name LIKE '%"+words[i]+"%' order by sales_volume desc";
						ps = conn.prepareStatement(query);}
						
					else if(words[i]!=" "&i!=0) {
						query += "or name LIKE '%"+words[i]+"%' order by sales_volume desc";
						ps = conn.prepareStatement(query);}
					else {
						
						query += "(SELECT name, price, img_urls,sales_volume, type FROM product order by sales_volume)) where page=?";
						ps = conn.prepareStatement(query);
						ps.setInt(1, page);
					}
						
						System.out.println(query);
				
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(new ProductVO(rs.getString("name"), rs.getInt("price"), rs.getString("img_urls"), rs.getString("type")));
				}
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public int countSearchProduct(String[] words , int page) throws SQLException {
		System.out.println("countsearchproduct");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("a "+words);
		int count = 0;
		
		try {
			conn= getConnect();
			System.out.println("뭐지?");
			String query = "SELECT count(-1) FROM ";
			query += "(SELECT name, price, img_urls, type,sales_volume, ceil(rownum/5) AS page FROM ";
			for(int i=0; i <= words.length-1;i++) {
					if(words[i]!=" "&i==0) {
						query += "product) WHERE name LIKE '%"+words[i]+"%' order by sales_volume desc";
						ps = conn.prepareStatement(query);
						System.out.println("aa "+words);
					}	else if(words[i]!=" "&i!=0) {
						query += "or name LIKE '%"+words[i]+"%' order by sales_volume desc";
						System.out.println("aaa "+words);
						ps = conn.prepareStatement(query);}
					else {
						
						query += "(SELECT name, price, img_urls,sales_volume, type FROM product order by sales_volume))";
						System.out.println("aaaaa "+words);
						ps = conn.prepareStatement(query);
					}
						
						System.out.println(query);
				
				rs = ps.executeQuery();
				if(rs.next()) count+=rs.getInt(1);
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		System.out.println("product count return");
		return count;
	}
	
	public ArrayList<RecipeVO> searchRecipe(ArrayList<String> words, int page) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		try {
			conn= getConnect();
			String query = "SELECT no, name, img_urls, main_ingredients, writer,register_date, type, hits FROM "
					+ "(SELECT no, name, img_urls, main_ingredients ,writer,register_date, type, hits, ceil(rownum/6) AS page FROM ";
			System.out.println("words.size() :: "+words.size());
			 if(words.size()==0){
					query += "(SELECT no, name, img_urls, main_ingredients ,writer,register_date, type, hits FROM recipe order by no desc)) where page=?";
					ps = conn.prepareStatement(query);
					ps.setInt(1, page);
					rs = ps.executeQuery();
					while(rs.next()) {
						list.add(new RecipeVO(rs.getInt("no"),rs.getString("name"),rs.getString("img_urls"),rs.getString("main_ingredients"),
								rs.getString("writer"), rs.getString("register_date"),rs.getString("type"),rs.getInt("hits")));
					}
				}else{
			for(int i=0; i < words.size();i++) {

				if(words.size()!=0&&i==0) {
					query += "recipe) WHERE name LIKE '%"+words.get(i)+"%'";
				}else if(words.size()!=0&&i!=0) {
					query += " or name LIKE '%"+words.get(i)+"%'";
				}else
				query += " order by hits desc";
				System.out.println(query);
				ps = conn.prepareStatement(query);
				ps.setInt(1, page);
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(new RecipeVO(rs.getInt("no"),rs.getString("name"),rs.getString("img_urls"),rs.getString("main_ingredients"),
							rs.getString("writer"), rs.getString("register_date"),rs.getString("type"),rs.getInt("hits")));
				}
			}}
			
		
		}finally {
			closeAll(rs, ps, conn);
		}
		System.out.println("return recipe list :: "+list);
		return list;
	}
	
	public int countSearchRecipe(ArrayList<String> words, int page) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;
		
		try {
			conn= getConnect();
			String query = "SELECT count(-1) FROM "
					+ "(SELECT no, name, img_urls, main_ingredients ,writer,register_date, type, hits, ceil(rownum/6) AS page FROM ";
			System.out.println("words.size() :: "+words.size());
			 if(words.size()==0){
					query += "(SELECT no, name, img_urls, main_ingredients ,writer,register_date, type, hits FROM recipe order by no desc)) ";
					ps = conn.prepareStatement(query);
					System.out.println(query);
					rs = ps.executeQuery();
					while(rs.next()) {
						count += rs.getInt(1);
					}
				}else{
			for(int i=0; i < words.size();i++) {

				if(words.size()!=0&&i==0) {
					query += "recipe) WHERE name LIKE '%"+words.get(i)+"%'";
				}else if(words.size()!=0&&i!=0) {
					query += " or name LIKE '%"+words.get(i)+"%'";
				}else
				query += " order by hits desc";
				System.out.println(query);
				ps = conn.prepareStatement(query);
				
				rs = ps.executeQuery();
				while(rs.next()) {
					count += rs.getInt(1);
				}
			}}
			 
			query += " order by hits desc";
			ps = conn.prepareStatement(query);
			System.out.println(query);
			
			rs = ps.executeQuery();
			if(rs.next())count += rs.getInt(1);
		}finally {
			closeAll(rs, ps, conn);
		}
		System.out.println("return recipe count :: " + count);
		return count;
	}
	
	public ArrayList<ProductVO> searchProduct(ArrayList<String> words , int page) throws SQLException {
		System.out.println("searchproduct words");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		
		try {
			conn= getConnect();
			String query = "SELECT name, price, img_urls, type FROM  ";
			query += "(SELECT name, price, img_urls, type,sales_volume, ceil(rownum/5) AS page FROM ";
			 if(words.size()==0){
					query += "(SELECT name,  price, img_urls, type, sales_volume FROM product order by sales_volume desc)) where page=?";
					ps = conn.prepareStatement(query);
					System.out.println(query);
					ps.setInt(1, page);
					rs = ps.executeQuery();
					while(rs.next()) {
						list.add(new ProductVO(rs.getString("name"), rs.getInt("price"), rs.getString("img_urls"), rs.getString("type")));
					}
				}else{
			for(int i=0; i <= words.size()-1;i++) {
				if(words.get(i)!=" "&i==0) {
					query += "product) WHERE name LIKE '%"+words.get(i)+"%'";
				}
					
				else if(words.get(i)!=" "&i!=0) {
					query += " or name LIKE '%"+words.get(i)+"%'";
				}
			}
			query += " order by sales_volume desc";
			System.out.println(query);
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ProductVO(rs.getString("name"), rs.getInt("price"), rs.getString("img_urls"), rs.getString("type")));
			}
				}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public int countSearchProduct(ArrayList<String> words , int page) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int count = 0;
		
		try {
			conn= getConnect();

			String query = "SELECT count(-1) FROM ";
			query += "(SELECT name, price, img_urls, type,sales_volume FROM ";
			
			
			if(words.size()==0){
				query += "(SELECT name,  price, img_urls, type, sales_volume FROM product order by sales_volume desc))";
				ps = conn.prepareStatement(query);
				System.out.println(query);
				rs = ps.executeQuery();
				if(rs.next()) {
				count += rs.getInt(1);	
				}
			}else{
			
			
			for(int i=0; i <= words.size()-1;i++) {
					if(words.get(i)!=" "&i==0) {
						query += "product) WHERE name LIKE '%"+words.get(i)+"%'";

					}	else if(words.get(i)!=" "&i!=0) {
						query += " or name LIKE '%"+words.get(i)+"%'";
					}
		
			}
			
			}
			query += " order by sales_volume desc";
			System.out.println(query);
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			if(rs.next()) count+=rs.getInt(1);
		}finally {
			closeAll(rs, ps, conn);
		}
		System.out.println("product count return : "+count);
		return count;
	}
	// hits순 상위 5개만 보여지게
	/*public ArrayList<BoardVO1> showRecommandRecipe() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardVO1> list = new ArrayList<BoardVO1>();
		try {
			conn= getConnect();
			ps = conn.prepareStatement(ShowQuery.RECOMMEND_RECIPE);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new BoardVO1(rs.getInt("no"),rs.getString("title"),
						rs.getString("writer"),rs.getString("content"),
						rs.getString("hits")));
			}
			
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	*/
	
	public static void main(String[] args) throws SQLException {

		/*String[] str= {"소","아리","김"};
		ArrayList<RecipeVO> list = SearchDao.getInstance().searchRecipe(str);
		for(BoardVO1 b : list)
			System.out.println(b);*/
		

/*		ArrayList<BoardVO1> list = SearchDao.getInstance().searchRecommand();
		for(BoardVO1 b : list)
			System.out.println(b);*/
	}
}

