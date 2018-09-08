package com.zb.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.alibaba.fastjson.JSONObject;
import com.zb.entity.Bill;
import com.zb.entity.Provider;
import com.zb.entity.Users;
import com.zb.service.ProviderServices;
import com.zb.util.UUIDUtil;

@Controller
public class ProviderController {

	@Resource
	private ProviderServices providerServices;
	
	@RequestMapping("toBillList.do")
	public String toBillList(Model model){
		
		List<Provider> list = providerServices.findProvider();
		
		model.addAttribute("list", list);
		
		return "bill/billlist";
		
	}
	
	@RequestMapping("showRovider.do")
	@ResponseBody
	public String findprovider(){
		
		List<Provider> list = providerServices.findProvider();
		
		return JSONObject.toJSONString(list);
		
	}
	
	@RequestMapping("toprovider.do")
	public String toprovider(){
		
		return "provider/providerlist";
		
	}
	
	@RequestMapping("findProvider.do")
	@ResponseBody
	public String providerList(String queryProName,String queryProCode,int currentPage){
		
		
		List<Provider> list = providerServices.findAllProvider(queryProName, queryProCode, currentPage);
	
		
		int count = providerServices.findProviderCount(queryProName, queryProCode);
		
		int totalPage = count % 4 == 0 ? count / 4 : count / 4 + 1;
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("list", list);
		
		params.put("count", count);
		
		params.put("totalPage", totalPage);
		
		return JSONObject.toJSONString(params);
		
	}
	
	@RequestMapping("toProviderAdd.do")
	public String toProviderAdd(){
		
		return "provider/provideradd";
		
	}
	
	@RequestMapping("providerAdd.do")
	public String add(HttpServletRequest req,HttpSession session,Provider p){
	
		//�ļ�
		//��ȡӦ�÷������ľ��Ե�ַ
		ServletContext application = session.getServletContext();
		String rootPath = application.getRealPath("/");
		//��һ���ļ���
		String dirName = "upload";
		String dirPath = rootPath + dirName;
		File dirFile = new File(dirPath);
		if(!dirFile.exists()){
			//�����ļ���
			dirFile.mkdir();
		}
		
		//ת��req
		MultipartRequest request = (MultipartRequest) req;
		String cpath = this.uploadFile(request, "rolecphoto", dirPath,dirName);	//�ϴ���ҵӪҵִ���ļ�
		p.setCardphoto(cpath);					 
		String wpath = this.uploadFile(request, "rolewphoto", dirPath,dirName);	//�ϴ���֯��������֤�ļ�
		p.setWorkphoto(wpath);
		
		Users u = (Users) session.getAttribute("loginUser");
		
		p.setCreateby(u.getId());
		
		p.setCreationdate(new Date());
		
		providerServices.add(p);
		
		return "redirect:toprovider.do";
	}
	
	private String uploadFile(MultipartRequest request,String formName,String dirPath,String dirName){
		String result = "";
		try {
			MultipartFile cfile = request.getFile(formName);
			//�޸��ļ���
			String uuid = UUIDUtil.getUUID();
			String newFileName = uuid+cfile.getOriginalFilename().substring(cfile.getOriginalFilename().lastIndexOf("."));
			//�ļ��ϴ���ַ
			String path = dirPath + "/" + newFileName;
			byte[] b = cfile.getBytes();
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(b);
			fos.flush();
			fos.close();
			//File.separator ����Ӧ�ָ���
			result =  dirName + File.separator + newFileName;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	@RequestMapping("providerView.do")
	public String providerView(int id, String mode, Model model){
	
		Provider p = providerServices.findId(id);
		
		model.addAttribute("provider", p);
		
		String result="";
		
		if ("view".equals(mode)) {
			
			result = "provider/providerview";
			
		}else if("update".equals(mode)){
			
			result ="provider/providermodify";
			
		}
		return result;
	
	}
	
	@RequestMapping("providerModify.do")
	public String providerModify(HttpServletRequest req,HttpSession session,Provider p){
		
		//�ļ�
		//��ȡӦ�÷������ľ��Ե�ַ
 		ServletContext application = session.getServletContext();
		String rootPath = application.getRealPath("/");
		//��һ���ļ���
		String dirName = "upload";
		String dirPath = rootPath + dirName;
		File dirFile = new File(dirPath);
		if(!dirFile.exists()){
			//�����ļ���
			dirFile.mkdir();
		}
		
		//�����û���û���ϴ�ͼƬ
		//��ȡԭ����User�����
		Provider old = providerServices.findId(p.getId());
		
		MultipartRequest request = (MultipartRequest) req;
		
		MultipartFile cfile = request.getFile("rolecphoto");
		if(cfile.isEmpty()){
			//ʹ��ԭ����ͼƬ
			p.setCardphoto(old.getCardphoto());
		}else{
			String newPath = this.uploadFile(request, "rolecphoto", dirPath, dirName);
			p.setCardphoto(newPath);
			//ɾ������Ƭ
			File oldFile = new File(rootPath + old.getCardphoto());
			if(oldFile.exists()){
				oldFile.delete();
			}
		}
		
		
		MultipartFile wfile = request.getFile("rolewphoto");
		if(wfile.isEmpty()){
			//ʹ��ԭ����ͼƬ
			p.setWorkphoto(old.getWorkphoto());
		}else{
			String newPath = this.uploadFile(request, "rolewphoto", dirPath, dirName);
			p.setWorkphoto(newPath);
			//ɾ������Ƭ
			File oldFile = new File(rootPath + old.getWorkphoto());
			if(oldFile.exists()){
				oldFile.delete();
			}
		}
		
		 Users u = (Users) session.getAttribute("loginUser");
		 
		 p.setModifyby(u.getId());
		 
		 p.setModifydate(new Date());
		 
		int i =  providerServices.upd(p);
		 
		System.out.println(i);
		 return "redirect:toprovider.do";
		 
	}
	
	@RequestMapping("providerdelete.do")
	public String providerdel(int id){
		
		System.out.println(id);
		providerServices.del(id);
		
		return "redirect:toprovider.do";
		 
	}
}
