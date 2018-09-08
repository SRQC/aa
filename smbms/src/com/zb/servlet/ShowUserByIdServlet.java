package com.zb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zb.entity.Users;
import com.zb.service.UsersService;
import com.zb.service.impl.UsersServiceImpl;

public class ShowUserByIdServlet extends HttpServlet {

	
	private UsersService service = new UsersServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String mode = request.getParameter("mode");
		
		Users u = service.findById(id);
		
		request.setAttribute("u", u);
		if("view".equals(mode)){
			request.getRequestDispatcher("WEB-INF/jsp/user/userview.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("WEB-INF/jsp/user/usermodify.jsp").forward(request, response);
		}
		
	}

}
