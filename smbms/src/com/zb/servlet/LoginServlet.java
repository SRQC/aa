package com.zb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zb.entity.Users;
import com.zb.service.UsersService;
import com.zb.service.impl.UsersServiceImpl;

public class LoginServlet extends HttpServlet {

	
	private UsersService service = new UsersServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//接值
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("userpassword");
		Users u = service.login(username, password);
		
		if(u != null){
			//登陆成功
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", u);
			
			request.getRequestDispatcher("WEB-INF/jsp/frame.jsp").forward(request, response);
			
		}else{
			request.setAttribute("loginflag", "error");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		
	}

}
