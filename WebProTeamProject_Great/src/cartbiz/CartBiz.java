package cartbiz;
/*
 * itemView ���������� ��ٱ��� ��⸦ Ŭ���ϸ� �۵��ؾ��ϴ� ��ٱ����� �����Ͻ� ����
 * 1) �̹� ��ٱ��Ͽ� ����� Item�� �߰��ϴ� ��� 
 * 2)��ٱ��Ͽ� ������� ���� Item�� �߰��ϴ� ���
 * --> īƮ�� �߰��Ϸ��� Item�� �ִ��� ���������� ���� �˾ƾ� �Ѵ�
 * �ִٸ� ---- ������ ����
 * ���ٸ� --- ���ο� Item�� ����
 * ::
 * 1. ���ǿ� ����� ��� �����۵��� �޾ƿ��� ����..ArrayList�� ��ȯ
 * 2. Item�� �߰��ϴ� ���� (1���� ���� ����� �ΰ����� ������)
 */

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.vo.CartVO;
import model.vo.MemberVO;
import model.vo.ProductVO;

public class CartBiz {
	/*
	 * ���ǿ� ���ε��� cartList����Ʈ ������ �� �޾ƿ´�...
	 */
	public ArrayList<CartVO> getCartList(HttpServletRequest request){
		HttpSession session = request.getSession();	
		ArrayList<CartVO> cartList= (ArrayList<CartVO>)session.getAttribute("cartList");
		return cartList;
	}
	/*
	 * getCartList()�� ȣ���ؾ��Ѵ�.
	 * Item�� �ش��ϴ� ��ǰ�� cartList�� �ִٸ�....������ ����
	 * ���ٸ�...Cart�� �ϳ��� �߰��ؾ��Ѵ�.(Cart�� ����)
	 */	
	public void addCart(HttpServletRequest request,ProductVO product) { //?
		HttpSession session = request.getSession();	
		ArrayList<CartVO> cartList = (ArrayList<CartVO>)session.getAttribute("cartList");
		String id = ((MemberVO)session.getAttribute("login")).getId();
		System.out.println(id);
		if(cartList==null) cartList = new ArrayList<CartVO>();
		
		System.out.println(cartList);
		CartVO cart = null;
		boolean newCart = true;
		//�ϳ� �̻��� Item�� ��ٱ��Ͽ� �ִٸ�...
		//cartList�� ����ִ� Item�� �߰��Ϸ��� Item�� �̸��� ���ٸ�
		//������ ����...
		for(CartVO c :cartList) {
			if(c.getName().equals(product.getName())) {
				newCart = false;
				c.setQuantity(c.getQuantity()+1);
			}//if
		}//for
		
		if(newCart) { //īƮ�� ����ִ� ��ǰ�� �ƴ϶��
			cart = new CartVO(id,product.getName(),product.getPrice(),1,product.getImg_urls());
				
			cartList.add(cart);
		}//
		System.out.println("addcart ��� : "+cartList);
		session.setAttribute("cartList", cartList);
		
	}//addCart
	/*
	 * ���ǿ� ���ε��� ArrayList�� �޾ƿͼ�
	 * ���߿��� ������ �����Ϸ��� name�� ��ġ�ϴ� ��ǰ�� �޾ƿͼ�
	 * name�� �ش��ϴ� ��ǰ�� ������ �ϳ��� ������Ű�� ������ �ۼ�
	 */
	public void upCartQty(ArrayList<CartVO> cartList,String id, String name) {
		
		for(CartVO c : cartList) {
			if(c.getUserId().equals(id)) {
			if(c.getName().equals(name)) c.setQuantity(c.getQuantity()+1);		
			}
		}//for		
	}//upCartQty
	
	public void downCartQty(ArrayList<CartVO> cartList,String id, String name) {
		
		for(CartVO c : cartList) {
			if(c.getUserId().equals(id)) {
			if(c.getName().equals(name)) c.setQuantity(c.getQuantity()-1);	
			}
		}//for			
	}//upCartQty
	
	
	public void removeCartItem(ArrayList<CartVO> cartList, String[] names) {
		
		
		for(int i =0; i<names.length; i++) {
			for(int j=0; j<cartList.size(); j++) {
				if(names[i].equals(cartList.get(i).getName()))
					cartList.remove(cartList.get(j));
			}
		}
	}//removeCartItem
}































