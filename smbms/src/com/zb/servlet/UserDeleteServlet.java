package com.zb.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zb.entity.Users;
import com.zb.service.UsersService;
import com.zb.service.impl.UsersServiceImpl;

public class UserDeleteServlet extends HttpServlet {

	private UsersService service =new UsersServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		
		Users u = service.findById(id);
		
		ServletContext application = this.getServletContext();
		String rootPath = application.getRealPath("/");
		String cardphoto = u.getCardphoto();
		if(cardphoto != null && !"".equals(cardphoto)){
			String filePath = rootPath + cardphoto;
			File f = new File(filePath);
			if(f.exists()){
				f.delete();
			}
		}
		
		String workphoto = u.getWorkphoto();
		if(workphoto != null && !"".equals(workphoto)){
			String filePath = rootPath + workphoto;
			File f = new File(filePath);
			if(f.exists()){
				f.delete();
			}
		}
		
		
		service.deleteUsers(id);
		
		response.sendRedirect("toUserlistServlet");
		
		
	}

}
