package com.zb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.zb.dao.RoleDao;
import com.zb.entity.Role;
import com.zb.service.RoleService;
import com.zb.service.impl.RoleServiceImpl;

public class AjaxShowRoleServlet extends HttpServlet {

	private RoleService service = new RoleServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Role> list = service.findRoles();
		String json = JSONObject.toJSONString(list);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
	}

}
