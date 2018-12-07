package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.vo.ProductVO;
import model.vo.RecipeVO;
import query.ShowQuery;
import query.StringQuery;

public class RecipeDAO {
  
	DataSource ds;
	private static RecipeDAO dao= new RecipeDAO();
	private RecipeDAO() {
		ds=DataSourceManager.getInstance().getConnection();
	}
	public static RecipeDAO getInstance() {
		System.out.println("recipedao return");
		return dao;
	}
	public Connection getConnection() throws SQLException{
		System.out.println("return connection");
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
	
	
	
	
	
	//레시피 등록
		public void registerRecipe(RecipeVO mvo) throws SQLException{
			Connection conn = null;
			PreparedStatement ps = null;
			try{
				//id,password,name,email,birthday,address
				conn=getConnection();
				ps = conn.prepareStatement(StringQuery.INSERT_RECIPE);
				ps.setInt(1, 1);
				ps.setString(2, mvo.getName());
				ps.setString(3, mvo.getImgurls());
				ps.setString(4, mvo.getMain_ingredients());
				ps.setString(5, mvo.getSub_ingredients());
				ps.setString(6, mvo.getWriter());
				ps.setString(7, mvo.getDate());
				ps.setString(8, mvo.getType());
				ps.setInt(9, mvo.getHits());
				ps.setString(10, mvo.getDescript());
				ps.setString(11, mvo.getContent());
				ps.setString(12, mvo.getTip());
				if(ps.executeUpdate()!=0){
					System.out.println(mvo.getName()+" 메뉴 등록 성공!!");
				}
			}finally{
				closeAll(ps, conn);
			}
		}
		
		public int recipeWrite(RecipeVO vo) throws SQLException{
			System.out.println(" recipeWrite 호출");
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			int num=-1;
			try {
				conn = getConnection();
				ps = conn.prepareStatement(StringQuery.INSERT_RECIPE);
				System.out.println(StringQuery.INSERT_RECIPE);
				/*this.name = name;
				this.imgurls = imgurls;
				this.main_ingredients = main_ingredientents;
				this.sub_ingredients = sub_ingredientents;
				this.writer = writer;
				
				this.type = type;
				
				this.descript = descript;
				this.content = content;
				this.tip = tip;*/
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getImgurls());
				ps.setString(3, vo.getMain_ingredients());
				ps.setString(4, vo.getSub_ingredients());
				ps.setString(5, vo.getWriter());
				ps.setString(6, vo.getType());
				ps.setString(7, vo.getDescript());			
				ps.setString(8, vo.getContent());
				ps.setString(9, vo.getTip());
				
							
				int row = ps.executeUpdate();
				
				ps = conn.prepareStatement(StringQuery.CURRENT_RECIPE);
				rs = ps.executeQuery();
				
				
				if(rs.next()) num= rs.getInt(1);
				System.out.println(row+" row insert recipe ok....");
				
				System.out.println("dao CURRENT_NO...before...."+vo.getName());//x
			
				
			}finally{
				closeAll(ps, conn);
			}
			
			return num;
		}	
		
		//레시피삭제
		public void deleteRecipe(int no) throws SQLException{
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = getConnection();
				ps = conn.prepareStatement(StringQuery.DELETE_RECIPE);
				ps.setInt(1, no);
				int row = ps.executeUpdate();
				System.out.println(row+ "ROW DELETE OK!!! ");
			}finally {
				closeAll(ps, conn);
			}
		}
		
		//레시피수정
		public void updateRecipe(RecipeVO vo)throws SQLException{
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = getConnection();
				ps = conn.prepareStatement(StringQuery.UPDATE_RECIPE);			
				
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getImgurls());
				ps.setString(3, vo.getMain_ingredients());
				ps.setString(4, vo.getSub_ingredients());
				ps.setString(5, vo.getWriter());
				
				ps.setString(6, vo.getType());
				ps.setInt(7, vo.getHits());
				ps.setString(8, vo.getDescript());			
				ps.setString(9, vo.getContent());
				ps.setString(10, vo.getTip());
				ps.setInt(11, vo.getNum());
				
				
				int row=  ps.executeUpdate();
				System.out.println(row+" ROW UPDATE OK!!!");
			}finally {
				closeAll(ps, conn);
			}
		}
		
		
		
		
		
		//--------------------------------------------------------------------------------------------------
		//----------------------------------------show
		
		//관련레시피
		 public ArrayList<RecipeVO> showRelatedRecipe(int no) throws SQLException{
			 System.out.println("related recipe");
		      Connection conn = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		      try {
		         conn = getConnection();
		         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWRELATEDRECIPE);
		         System.out.println(ShowQuery.SELECT_SHOWRELATEDRECIPE);
		         ps.setInt(1, no);
		         rs = ps.executeQuery();
		         while (rs.next()) {
		            list.add(new RecipeVO(rs.getInt("no"), rs.getString("name"), rs.getString("img_urls"),
		                  rs.getString("main_ingredients"), rs.getString("sub_ingredients"), rs.getString("writer"),
		                  rs.getString("register_date"), rs.getString("type"), rs.getInt("hits"),
		                  rs.getString("descript"), rs.getString("content"), rs.getString("tip"),
		                  rs.getString("recommend")));
		         }
		      } finally {
		         closeAll(rs, ps, conn);
		      }
		      return list;
		   }
		 //관련 상품
		 public ArrayList<ProductVO> showRelatedProduct(String ingrediants) throws SQLException{
			 System.out.println("related product");
		      Connection conn = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		      System.out.println(ingrediants);
		      String[] words = ingrediants.split(",");
		      System.out.println(words);
		      try {
		         conn = getConnection();
		         
		         String query = "SELECT name, price, img_urls, type FROM product WHERE name LIKE '%"+words[0]+"%'";
		         if(words.length>0) {
		         for(int i=1; i < words.length;i++) {
		        	 	
								query += " OR name LIKE '%"+words[i]+"%'";
		         }
		         	query+= "order by sales_volume desc";
		         	
						ps = conn.prepareStatement(query);
						rs = ps.executeQuery();
						while(rs.next()) {
							list.add(new ProductVO(rs.getString("name"), rs.getInt("price"), rs.getString("img_urls"), rs.getString("type")));
						}
		         
						
		      }
		      } finally {
		         closeAll(rs, ps, conn);
		      }
		      return list;
		   }
		 //추천레시피
		 public ArrayList<RecipeVO> showRecipeRecommend() throws SQLException {
			 System.out.println("showRecipeRecommend");
		      Connection conn = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		      try {
		         conn = getConnection();
		         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWRECOMMENDRECIPE);
		         System.out.println(ShowQuery.SELECT_SHOWRECOMMENDRECIPE);
		         rs = ps.executeQuery();
		         while (rs.next()) {
		            list.add(new RecipeVO(rs.getInt("no"), rs.getString("name"), rs.getString("img_urls"),
		                  rs.getString("main_ingredients"), rs.getString("sub_ingredients"), rs.getString("writer"),
		                  rs.getString("register_date"), rs.getString("type"), rs.getInt("hits"),
		                  rs.getString("descript"), rs.getString("content"), rs.getString("tip"),
		                  rs.getString("recommend")));
		         }
		         System.out.println(list);
		      } finally {
		         closeAll(rs, ps, conn);
		      }
		      return list;
		   }
		 
		 //최신레시피
		 public ArrayList<RecipeVO> showRecipeNew() throws SQLException {
		      Connection conn = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		      try {
		         conn = getConnection();
		         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWNEWRECIPE);
		         rs = ps.executeQuery();
		         while (rs.next()) {
		            list.add(new RecipeVO(rs.getInt("no"), rs.getString("name"), rs.getString("img_urls"),
		                  rs.getString("main_ingredients"), rs.getString("sub_ingredients"), rs.getString("writer"),
		                  rs.getString("register_date"), rs.getString("type"), rs.getInt("hits"),
		                  rs.getString("descript"), rs.getString("content"), rs.getString("tip"),
		                  rs.getString("recommend")));
		         }
		      } finally {
		         closeAll(rs, ps, conn);
		      }
		      return list;
		   }
		 
		 //핫한 레시피
		 public ArrayList<RecipeVO> showRecipeHot() throws SQLException {
		      Connection conn = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		      try {
		         conn = getConnection();
		         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWHOTRECIPE);
		         System.out.println(ShowQuery.SELECT_SHOWHOTRECIPE);
		         rs = ps.executeQuery();
		         while (rs.next()) {
		            list.add(new RecipeVO(rs.getInt("no"), rs.getString("name"), rs.getString("img_urls"),
		                  rs.getString("main_ingredients"), rs.getString("sub_ingredients"), rs.getString("writer"),
		                  rs.getString("register_date"), rs.getString("type"), rs.getInt("hits"),
		                  rs.getString("descript"), rs.getString("content"), rs.getString("tip"),
		                  rs.getString("recommend")));
		         }
		      } finally {
		         closeAll(rs, ps, conn);
		      }
		      return list;
		   }
		 
		 
		 //레시피 디테일
		   public RecipeVO showRecipe(int no) throws SQLException {
		      Connection conn = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      RecipeVO vo = null;
		      try {
		         conn = getConnection();
		         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWRECIPE);
		         ps.setInt(1, no);
		         rs = ps.executeQuery();
		         if (rs.next()) {
		            vo =new RecipeVO(rs.getInt("no"), rs.getString("name"), rs.getString("img_urls"),
		                  rs.getString("main_ingredients"), rs.getString("sub_ingredients"), rs.getString("writer"),
		                  rs.getString("register_date"), rs.getString("type"), rs.getInt("hits"),
		                  rs.getString("descript"), rs.getString("content"), rs.getString("tip"),
		                  rs.getString("recommend"));
		         }
		      } finally {
		         closeAll(rs, ps, conn);
		      }
		      return vo;
		   }
		   
		   
}
