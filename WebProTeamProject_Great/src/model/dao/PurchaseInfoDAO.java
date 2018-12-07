package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.vo.CartVO;
import model.vo.PurchaseInfoVO;
import query.ShowQuery;
import query.StringQuery;

public class PurchaseInfoDAO {
   DataSource ds;
   private static PurchaseInfoDAO dao = new PurchaseInfoDAO();

   private PurchaseInfoDAO() {
      ds = DataSourceManager.getInstance().getConnection();
   }

   public static PurchaseInfoDAO getInstance() {

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
   //초기 설정 끝
   
   
   
   //구매 정보 등록
   //------주문날짜/상품이름/가격/수량/img/배송날짜--------------
   public PurchaseInfoVO PurchaseInfoInsert(CartVO vo) throws SQLException{
      Connection conn = null;
      PreparedStatement ps = null;
      
      PurchaseInfoVO pvo = new PurchaseInfoVO();
      System.out.println("PurchaseInfoDAO 진입함");
      
      try {
         
         conn = getConnection();
         ps = conn.prepareStatement(StringQuery.INSERT_PURCHASE);
         System.out.println("이제 슬슬 값 받아와서 맵핑해볼까?");
         //CartVO에서 값을 받아와서 pvo에 저장한다.
         pvo.setProname(vo.getName());
         System.out.println("pvo name :: "+pvo.getProname());
         
         pvo.setProprice(vo.getPrice());
         System.out.println("pvo price :: "+pvo.getProprice());
         
         pvo.setProamount(vo.getQuantity());
         System.out.println("pvo amount :: "+pvo.getProamount());
         
         pvo.setImg_urls(vo.getImg_urls());
         System.out.println("pvo Img_urls :: "+pvo.getImg_urls());
         
         System.out.println("맵핑 끝");
         //================================================================================
         System.out.println("이제 디비값에 저장해볼까???");
         //ps.setString(1, pvo.getDate());
         ps.setString(1, pvo.getProname());
         ps.setInt(2,pvo.getProprice());
         ps.setInt(3, pvo.getProamount());
         ps.setString(4, pvo.getImg_urls());
         //ps.setString(6, pvo.getDelivery_date());
         
         
         int row = ps.executeUpdate();
         System.out.println(row+" row insert product ok....");
         System.out.println(" DB 입력 완료");
            
      }finally{
         closeAll(ps, conn);
      }
      return pvo;
   }
   
   //구매 정보 가져옴
   public ArrayList<PurchaseInfoVO> showPurchaseInfo(String id) throws SQLException{
      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      ArrayList<PurchaseInfoVO> list=new ArrayList<PurchaseInfoVO>();

      try {
         conn = getConnection();
         ps = conn.prepareStatement(ShowQuery.SHOW_PURCHASE);
         System.out.println(ShowQuery.SHOW_PURCHASE);
         ps.setString(1, id);
         rs = ps.executeQuery();
         System.out.println("쿼리문 수행함");
         while (rs.next()) {
                 list.add(new PurchaseInfoVO(rs.getString("PURCHASE_DATE"),rs.getString("PRO_NAME"),rs.getInt("PRO_PRICE"),
                        rs.getInt("PRO_AMOUNT"),rs.getString("IMG_URLS"),rs.getString("DELIVERY_DATE"),rs.getString("USER_ID")));
               }
         System.out.println(" showPurchaseInfo() ok....");
            
      }finally{
         closeAll(rs, ps, conn);
      }
      return list;
   }
}