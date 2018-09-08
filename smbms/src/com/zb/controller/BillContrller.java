package com.zb.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zb.entity.Bill;
import com.zb.entity.Users;
import com.zb.service.BillServices;

@Controller
public class BillContrller {

	@Resource
	private BillServices billServices;
	
	@RequestMapping("findBill.do")
	@ResponseBody
	public String billList(String queryProductName,int queryProviderId,int queryIsPayment,int currentPage){
		
		List<Bill> list = billServices.findBill(queryProductName, queryProviderId, queryIsPayment, currentPage);
	
		int count = billServices.findBillCount(queryProductName, queryProviderId, queryIsPayment);
		
		int totalPage = count % 4 == 0 ? count / 4 : count / 4 + 1;
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("list", list);
		
		params.put("count", count);
		
		params.put("totalPage", totalPage);
		
		return JSONObject.toJSONString(params);
		
	}
	
	@RequestMapping("toBillAdd.do")
	public String toBillAdd(){
		
		return "bill/billadd";
		
	}
	
	@RequestMapping("billadd.do")
	public String add(HttpSession session,Bill b){
		
		Users u = (Users) session.getAttribute("loginUser");
		
		b.setCreateby(u.getId());
		
		b.setCreationdate(new Date());
		
		billServices.add(b);
		
		return "redirect:toBillList.do";
	}
	
	@RequestMapping("billView.do")
	public String billView(int id, String mode, Model model){
	
		Bill b = billServices.findId(id);
		
		model.addAttribute("bill", b);
		
		String result="";
		
		if ("view".equals(mode)) {
			
			result = "bill/billview";
			
		}else if("update".equals(mode)){
			
			result ="bill/billmodify";
			
		}
		return result;
	
	}
	
	@RequestMapping("billModify.do")
	public String billModify(HttpSession session,Bill b){
		
		 Users u = (Users) session.getAttribute("loginUser");
		 
		 b.setModifyby(u.getId());
		 
		 b.setModifydate(new Date());
		 
		 billServices.upd(b);
		 
		 return "redirect:toBillList.do";
		 
	}
	
	@RequestMapping("billdelete.do")
	public String billdel(int id){
		
		billServices.del(id);
		
		return "redirect:toBillList.do";
		 
	}
	
}
