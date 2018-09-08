package com.zb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zb.entity.Bill;
import com.zb.entity.Provider;
import com.zb.entity.Role;
import com.zb.entity.Users;
import com.zb.service.RoleService;

@Controller
public class RoleController {
	
	@Resource
	private RoleService roleService;
	
	@RequestMapping("toUserList.do")
	public String toUserList(Model model){
		List<Role> list = roleService.findRoles();
		model.addAttribute("rlist", list);
		return "user/userlist";
	}
	
	@RequestMapping("showRole.do")
	public void showRole(HttpServletResponse response){
		try {
			List<Role> list = roleService.findRoles();
			String json = JSONObject.toJSONString(list);
			
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("toRoleList.do")
	public String toRoleList(){
		
		return "role/rolelist";
		
	}
	
	@RequestMapping("findRole.do")
	@ResponseBody
	public String roleList(){
		
		 List<Role> list = roleService.findRoles();
	
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("list", list);
		
		return JSONObject.toJSONString(params);
		
	}
	
	@RequestMapping("toRoleAdd.do")
	public String toRoleAdd(){
		
		return "role/roleadd";
		
	}
	@RequestMapping("roleAdd.do")
	public String add(HttpSession session,Role r){
		
		Users u = (Users) session.getAttribute("loginUser");
		
		r.setCreateby(u.getId());
		
		r.setCreationdate(new Date());
		
		roleService.addRole(r);
		
		return "redirect:toRoleList.do";
	}
	
	@RequestMapping("roledelete.do")
	public String roledel(int id){
		
		roleService.deleteRole(id);
		
		return "redirect:toRoleList.do";
		 
	}
	
	@RequestMapping("toRoleModify.do")
	public String roleModify(int id,Model model){
		
		Role r = roleService.findById(id);
		
		model.addAttribute("r", r);
		
		return "role/rolemodify";
	}
	
	@RequestMapping("roleModify.do")
	public String toRoleModify(HttpSession session,Role r){
			
		Users u = (Users) session.getAttribute("loginUser");
		
		r.setModifyby(u.getId());
		
		r.setModifydate(new Date());
		
		roleService.updateRole(r);
		
		return "redirect:toRoleList.do";
		
	}
	
	@RequestMapping("roleCheckCode.do")
	@ResponseBody
	public String checkCode(String code){
		
		 int count = roleService.checkCode(code);
		 
		 Map<String,Object> params = new HashMap<String, Object>();
		 
		 params.put("couunt", count);
		 
		 return JSONObject.toJSONString(params);
	}
}