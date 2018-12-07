package controller;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ShowDao;
import model.dao.RecipeDAO;
import model.vo.MemberVO;
import model.vo.RecipeVO;

public class Write_RecipeController implements Controller {

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   ModelAndView mv= new ModelAndView();
	   String realFolder = "";
	   System.out.println("writeController!!!!");
	   int maxSize = 1024*1024*5;
	   String encType = "utf-8";
	   String savefile = "img\\upload";
	   ServletContext scontext = request.getServletContext();
	   realFolder = scontext.getRealPath(savefile);
	   String mainfile = "";
	      
	   try{
		   MultipartRequest multi=new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		    mainfile = multi.getFilesystemName("imgurls");
		  
		
	  
	   
	   String imgurls = ".\\"+savefile + "\\" + mainfile;
	   
	   
      String name=multi.getParameter("name");
      System.out.println("name:"+name);
      
      
      
      System.out.println(name+"/"+imgurls);
      String main_ingredientent=multi.getParameter("ingredient1");
      for(int i=2; i<=3; i++) {
    	  if(!multi.getParameter("ingredient"+i).equals("")) {
    		  main_ingredientent+=",";
    	 	  main_ingredientent+=multi.getParameter("ingredient"+i);
    	  }else {break;}
      }
      
      String sub_ingredientent=multi.getParameter("sub_ingredient1");
      for(int i=2; i<=3; i++) {
    	  if(!multi.getParameter("sub_ingredient"+i).equals("")) {
    		  sub_ingredientent+=",";
    		  sub_ingredientent+=multi.getParameter("sub_ingredient"+i);
    	  }else {break;}
      }
      System.out.println("main : "+main_ingredientent+"/sub : "+sub_ingredientent);
      
      HttpSession session = request.getSession();
      String type=multi.getParameter("type");
      MemberVO mvo = (MemberVO)session.getAttribute("login");
      String writer=null;
      if(mvo.equals(null)) writer="包府磊";
      else writer=mvo.getId();
      System.out.println(writer);
      String discript = multi.getParameter("discript");
      System.out.println(discript);
      int count = Integer.parseInt((String)multi.getParameter("count"));
      System.out.println("count : "+count);
      String content = multi.getParameter("way_1");
      String filename=null;
      filename=multi.getFilesystemName("way_1_url");
      if(filename != null) 
    	  content +="/_/"+".\\"+savefile + "\\" +multi.getFilesystemName("way_1_url");
      else
    	  content +="/_/"+"null";
      
      for(int i=2; i<count; i++) {
    	  if(!multi.getParameter("way_"+i).equals(null)) {
    		  content+="///"+multi.getParameter("way_"+i)+"/_/";
    	  
    	  if(!multi.getFilesystemName("way_"+i+"_url").equals(null))
    		  
    		  content+=".\\"+savefile + "\\" +multi.getFilesystemName("way_"+i+"_url");
    	  else content+="null";
    	  
    	  }else if(!multi.getFilesystemName("way_"+i+"_url").equals(null))
    		  content+="///null/_/"+".\\"+savefile + "\\" +multi.getFilesystemName("way_"+i+"_url");
    	  }
      System.out.println(content);
     String tip = multi.getParameter("tip");
     
     
     
     
     RecipeVO rvo = new RecipeVO(name, imgurls, main_ingredientent, sub_ingredientent, writer, type, discript, content, tip);
     System.out.println(rvo);
     int num= RecipeDAO.getInstance().recipeWrite(rvo);
     System.out.println("Write_RecipeController"+num);
     
     
     System.out.println("ModelAndView 积己....");
     mv.setPath("showrecipedetail.do?num="+num);
     
	   } catch(Exception e) {
		   e.printStackTrace();
		  }
	   
	   return mv;
   	}
      
  
      
}
   
   /*
       @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String writer=request.getParameter("writer");
      String title=request.getParameter("title");
      String password=request.getParameter("password");
      String content=request.getParameter("content");
      
      //颇府固磐 vo  溜 pvo
      BoardVO pvo=new BoardVO(title, writer, password, content);
      BoardDao.getInstance().posting(pvo);
            
      ModelAndView mv= new ModelAndView();
      mv.setPath("DispatcherServlet?command=showContent&&no="+pvo.getNo());
      mv.setRedirect(true);
      
      return mv;
   }
    */
