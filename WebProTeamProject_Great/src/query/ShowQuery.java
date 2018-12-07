
package query;



import model.dao.CommonConstants;

public interface ShowQuery {
	// ��ȸ�� ������ �������� ������ ���� 4���� �����Ǹ� �˻��մϴ�.
		String SELECT_SHOWHOTRECIPE = "SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,"
				+ "hits, descript, content, tip,recommend from "
				+ "(SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,"
				+ "hits, descript, content, tip,recommend from recipe order by hits desc)" + "where ROWNUM<=4";
		// ������ �ѹ������� ���� ���ε�ϵ� ������ 4��
		String SELECT_SHOWNEWRECIPE = "SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,"
				+ "hits, descript, content, tip,recommend from "
				+ "(SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,"
				+ "hits, descript, content, tip,recommend from recipe order by no desc)" + "where ROWNUM<=4";

		// ��õ������ �����ڰ� �����ؼ� ��õ������ 2��
		String SELECT_SHOWRECOMMENDRECIPE = "SELECT no, name, img_urls ,main_ingredients ,sub_ingredients, writer, register_date, type,"
				+ "hits, descript, content, tip, recommend from recipe where recommend='true' AND ROWNUM<=4";

		// �Ǹŷ� �� �������� ������ ���� 4�� ��ǰ �˻�
		String SELECT_SHOWHOTPRODUCT = "SELECT name, price ,origin ,img_urls, content, type,"
				+ "brand, sales_volume,recommend, amount from product "
				+ "WHERE ROWNUM<=3";

		// ��õ ��ǰ �����ڰ� �����ؼ� ��õ ������ 2��
		String SELECT_SHOWRECOMMENDPRODUCT = "SELECT name, price ,origin ,img_urls, content, type,"
				+ "brand, sales_volume,recommend, amount from product WHERE recommend='true' AND ROWNUM<=2";

		// �������� ��ǰ�� :: no��ȣ ��ǰ�� ���������� ��ǰ�� ���� �˻� �ϴ� ���� ( ������� ��Ͻ� , �� �����ؼ� ����ؾ� �ϰ� ����� �̸��� ��ǰ�̸��� �����ؾ���.)
		String SELECT_SHOWINGREDIENTSPRODUCT = "SELECT main_ingredients FROM recipe where no=? ";
		
		// ���� ������ �޼ҵ� ���� Ÿ���� �����ǵ��� �����ȴ�.
		String SELECT_SHOWRELATEDRECIPE = "select * from recipe where type = (select type from recipe where no = ?)";
		
		String SELECT_SHOWRECIPE = "select*from recipe where no=?";
		
		String SELECT_SHOWPRODUCT = "select * from product where name=?";
	
	String REVIEW = "SELECT no, writer, img_urls, register_date, content FROM review";
	
	String NOTICE = "SELECT no, writer, register_date, content FROM notice";
	
	String REVIEW_PAGE_LIST = "SELECT no, writer, img_urls,register_date, content" +
            "(SELECT no, writer, img_urls,register_date, content, ceil(rownum/"+CommonConstants.CONTENT_NUMBER_PER_PAGE+") AS page FROM" +
            "(SELECT no, writer, img_urls,to_char(time_posted, 'YYYY.MM.DD') register_date, content FROM board order by no desc)) where page=?";
	
	String NOTICE_PAGE_LIST = "SELECT no, writer, register_date, content" +
            "(SELECT no, writer, register_date, content, ceil(rownum/"+CommonConstants.CONTENT_NUMBER_PER_PAGE+") AS page FROM" +
            "(SELECT no, writer, to_char(time_posted, 'YYYY.MM.DD') register_date, content FROM board order by no desc)) where page=?";

	String REVIEW_TOTAL_COUNT = "select count(-1) from review";
	
	String NOTICE_TOTAL_COUNT = "select count(-1) from notice";
	
	String RECOMMEND_RECIPE = "SELECT no, name, writer,register_date, content, hits FROM "
			+ "(SELECT no, title, writer, content, hits, CEIL(rownum/5) as page FROM "
			+ "(SELECT no, title, writer, content, hits FROM board ORDER BY hits DESC)) "
			+ "WHERE page=1";
		
		//������ ��ü����
		String SELECT_SHOWRECIPE2 = "select*from recipe";
		
	
		
		//������� ������ ���� ���뺸��
		String SELECT_SHOWPRODUCT2 = "select*from product";
		
		//��ȸ�� ����
		String UPDATE_RECIPEHITS = "UPDATE recipe SET hits=?+1 WHERE no=?";
		
		//���δ�Ʈ ����¡ + ������� ��ǰ ���� ���뺸��
		String PRODUCTPAGE_LIST = "SELECT name, price, origin, img_urls, content, page FROM"  +
             "(SELECT name, price, origin, img_urls, content, ceil(rownum/"+CommonConstants.CONTENT_NUMBER_PER_PAGE+") AS page FROM" +
             "(SELECT name, price, origin, img_urls, content FROM product)) where page=?";
		String PRODUCTTOTAL_COUNT = "select count(-1) from product";
		
		//������ ����¡ + ������� ������ ���� ���뺸��
		String RECIPEPAGE_LIST = "SELECT no, name, img_urls, main_ingredients ,descript, page FROM"  +
		              "(SELECT no, name, img_urls, main_ingredients ,descript, ceil(rownum/"+CommonConstants.CONTENT_NUMBER_PER_PAGE+") AS page FROM" +
		              "(SELECT no, name, img_urls, main_ingredients ,descript FROM recipe)) where page=?";
		String RECIPETOTAL_COUNT = "select count(-1) from recipe";
		String TYPEPRODUCT = "SELECT*from product WHERE type=?";
		String PRODUCTTYPETOTAL_COUNT = "select count(-1) from product where type=?";
		String TYPEPRODUCTPAGE_LIST = "SELECT name, price, origin, img_urls, content, type, page FROM"  +
	             "(SELECT name, price, origin, img_urls, content, type, ceil(rownum/"+CommonConstants.CONTENT_NUMBER_PER_PAGE+") AS page FROM" +
	             "(SELECT name, price, origin, img_urls, content, type FROM product where type=?)) where page=?";
		
		String SHOW_PURCHASE ="SELECT  PURCHASE_DATE, PRO_NAME, PRO_PRICE, PRO_AMOUNT,IMG_URLS,DELIVERY_DATE,User_ID  FROM purchase where user_id=? ORDER BY PURCHASE_DATE desc";
		 	
}

