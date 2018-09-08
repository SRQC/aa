package com.zb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.zb.entity.Users;
import com.zb.service.UsersService;
import com.zb.service.impl.UsersServiceImpl;

public class UserlistServlet extends HttpServlet {

	private UsersService service = new UsersServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接值
		request.setCharacterEncoding("utf-8");
		String queryname = request.getParameter("queryname");
		String queryUserRole = request.getParameter("queryUserRole");
		//当前页
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		//每页固定4条
		int pageSize = 4;
		
		//总记录数
		int count = service.findUsersCount(queryname, queryUserRole);
		//总页数
		int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		List<Users> list = service.findUsers(queryname,queryUserRole,currentPage);
		paramMap.put("list", list);
		paramMap.put("count", count);
		paramMap.put("totalPage", totalPage);
		//json
		String json = JSONObject.toJSONString(paramMap);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
	
	}

}
