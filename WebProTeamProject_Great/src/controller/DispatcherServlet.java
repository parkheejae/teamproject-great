package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String requestURI = request.getRequestURI();
		
		System.out.println(requestURI);
		String contextpath = request.getContextPath();
		System.out.println(contextpath);
		String command = requestURI.substring(contextpath.length()+1);
		System.out.println(command);
		
		Controller controller=HandlerMapping.getInstance().createFactory(command);
		
		
		
		String path= "index.jsp";
		ModelAndView mv = null;
		boolean isRedirect = true;		
		try {
			System.out.println("DispatcherServlet handleRequest..call...");
			mv = controller.handleRequest(request, response);
			System.out.println("DispatcherServlet handleRequest...mv :: "+mv);
			path = mv.getPath();
			isRedirect = mv.isRedirect();
		}catch(Exception e) {
			
		}//
		
		if(isRedirect) response.sendRedirect(path);
		else request.getRequestDispatcher(path).forward(request, response);		
	}
}

