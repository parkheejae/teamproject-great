
package controller;

public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {}
	
	public static HandlerMapping getInstance() {
		return factory;
	}
	
	//showproductdetail
	public Controller createFactory(String command) {
		Controller controller= null;
		System.out.println(command);
		if(command.equals("search.do")) {
			controller = new SearchController();
			System.out.println("SearchController ����...");
		}else if(command.equals("showmain.do")) {
			controller=  new ShowMainController();
			System.out.println("ShowMainController ����....");
		}else if(command.equals("showrecipedetail.do")) {
			controller=  new ShowRecipeController();
			System.out.println("ShowRecipeController ����....");
		}else if(command.equals("showproductdetail.do")) {
			controller= new SerchRecipeController();
			System.out.println("SerchRecipeController ����....");
		}else if(command.equals("insertrecipe.do")) {
			controller= new Write_RecipeController();
			System.out.println("WriteController ����....");
		}else if(command.equals("SerchRecipe.do")) {
			controller= new SerchRecipeController();
			System.out.println("SerchRecipeController ����....");
		}else if(command.equals("register.do")) {
			controller= new RegisterController();
			System.out.println("RegisterController ����....");
		}else if(command.equals("login.do")) {
			controller= new LoginController();
			System.out.println("LoginController ����....");
		}else if(command.equals("logout.do")) {
			controller = new LogoutController();
			System.out.println("LogoutController ����....");
		}else if(command.equals("idcheck.do")) {
			controller = new IdCheckController();
			System.out.println("IdCheckController ����....");
		}else if(command.equals("noticeList.do")) {
			controller = new NoticeListController();
			System.out.println("NoticeListController ����....");
		}else if(command.equals("noticedetail.do")) {
	         controller = new NoticeDetailController();
	         System.out.println("NoticeShowContentController ����....");
		}else if(command.equals("deleterecipe.do")) {
			controller = new DeleteRecipeController();
			System.out.println("DeleteRecipeController ����....");
		}else if(command.equals("serchmyrecipe.do")) {
			controller = new SerchMyRecipeController();
			System.out.println("SerchMyRecipeController ����....");
		}else if(command.equals("showProductDetail.do")) {
	         controller = new ProductDetailController();
	         System.out.println("productDetail ����....");
	     }else if(command.equals("writeReview.do")) {
		         controller = new WriteController();
		         System.out.println("WriteController ����....");
		}else if(command.equals("reviewdetail.do")) {
	         controller = new ReviewDetailController();
	         System.out.println("ReviewDetailController ����....");
		}else if(command.equals("reviewlist.do")) {
	         controller = new ReviewListController();
	         System.out.println("ReviewDetailController ����....");
		}else if(command.equals("Purchase.do")) {
	         controller = new PurchaseController();
	         System.out.println("PurchaseController ����....");
	    }else if(command.equals("itemAdd.do")) {
	         controller = new ItemCartAController();
	         System.out.println("ItemCartAController ����....");
	    }else if(command.equals("ItemCart.do")) {
	         controller = new ItemCartShowController();
	         System.out.println("ItemCartShowController ����....");
	    }else if(command.equals("itemCartQtyUp.do")) {
	         controller = new ItemCartQtyUpController();
	         System.out.println("ItemCartQtyUpController ����....");
	    }else if(command.equals("itemCartQtyDown.do")) {
	         controller = new ItemCartQtyDownController();
	         System.out.println("ItemCartQtyDownController ����....");
	    }else if(command.equals("itemDelete.do")) {
	         controller = new ItemCartDController();
	         System.out.println("ItemCartDController ����....");
	    }else if(command.equals("recipes.do")) {
			controller= new ShowRecipeController2();
			System.out.println("ShowRecipeController2 ����....");
		}else if(command.equals("header.do")) {
	         controller = new TodayProductController();
	         System.out.println("TodayProductController ����....");
	     }else if(command.equals("searchProduct.do")) {
	         controller = new SearchProductController();
	         System.out.println("SearchProductController ����....");
	     }else if(command.equals("shopmain.do")) {
				controller=  new ShopMainController();
				System.out.println("ShopMainController ����....");
			}else if(command.equals("PurchaseResult.do")) {
				controller=  new PurchaseResultController();
				System.out.println("PurchaseResultController ����....");
			}else if(command.equals("FastPurchase.do")) {
		         controller = new FastPurchaseController();
		         System.out.println("FastPurchaseController ����....");
		    }
		
		return controller;
	}
	
}
