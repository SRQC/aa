package com.zb.controller;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.alibaba.fastjson.JSONObject;
import com.zb.entity.Users;
import com.zb.service.UsersService;
import com.zb.util.UUIDUtil;

@Controller
public class UsersController {
	
	//以下内容 均为支线任务  
	//解决传值为日期格式
	//1.通过initBinder性质完成
//	@InitBinder		//
//	public void initBind(DataBinder binder){
//		//注册定制编辑器形式
//		binder.registerCustomEditor(Date.class, new DateEditor());
//	}
//	
//	private class DateEditor extends PropertyEditorSupport{
//
//		@Override
//		public void setAsText(String text) throws IllegalArgumentException {
//			try {
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				Date d = sdf.parse(text);
//				this.setValue(d);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	}
	
	

	@Resource
	private UsersService usersService;

	@RequestMapping("login.do")
	public String login(HttpSession session, String username,
			String userpassword, Model model) {
		// String str = null;
		// str.length();
		//
		Users u = usersService.login(username, userpassword);
		String result = "";
		if (u != null) {
			session.setAttribute("loginUser", u);

			result = "frame";

		} else {
			model.addAttribute("loginflag", "error");
			result = "forward:index.jsp"; // 破坏视图解析器的跳转

		}
		return result;
	}

	@RequestMapping("loginOut.do")
	public String loginOut(HttpSession session) {
		session.removeAttribute("loginUser");
		return "redirect:index.jsp"; // 重定向到index.jsp
	}

	//如果使用springMVC封装的ajax实现方式  存在2个问题
	//1.中文乱码
	//2.日期格式
	
	
	//中文乱码解决方案1：@RequestMapping(value="userlist.do",produces={"application/json;charset=utf-8"})
	//中文乱码解决方案2：在mvc:annotation-driven标签中配置
	/**
	 * <mvc:annotation-driven>
		<mvc:message-converters>
			<bean class="org.springframework.http.converter.StringHttpMessageConverter">
				<property name="supportedMediaTypes">
					<list>
						<value>application/json;charset=utf-8</value>
					</list>
				</property>
			</bean>
		
		</mvc:message-converters>
	</mvc:annotation-driven>
	 */
	
	//时间格式解决方案1：在属性上打上@JsonField注解
	
	
	//@RequestMapping(value="userlist.do",produces={"application/json;charset=utf-8"})
	@RequestMapping("userlist.do")
	@ResponseBody
	public String userlist(HttpServletResponse response, String queryname,
			String queryUserRole,@RequestParam(value="currentPage",defaultValue="1") int currentPage) {
		
			// 每页固定4条
			int pageSize = 4;

			// 总记录数
			int count = usersService.findUsersCount(queryname, queryUserRole);
			// 总页数
			int totalPage = count % pageSize == 0 ? count / pageSize : count
					/ pageSize + 1;

			Map<String, Object> paramMap = new HashMap<String, Object>();

			List<Users> list = usersService.findUsers(queryname, queryUserRole,
					currentPage);
			paramMap.put("list", list);
			paramMap.put("count", count);
			paramMap.put("totalPage", totalPage);
			// json
			String json = JSONObject.toJSONString(paramMap);
			return json;
		
	}
	
	@RequestMapping("toUserAdd.do")
	public String toUserAdd(@ModelAttribute("uuu")Users u){
		return "user/useradd";
	}

	//隐式接值     只要满足表单的name和对象的属性名一致 直接可以用对象接值
	@RequestMapping("useradd.do")
	public String useradd(HttpServletRequest req,HttpSession session,@ModelAttribute("uuu") @Valid Users u,BindingResult br){
		if(br.hasErrors()){
			return "user/useradd";
		}
		//文件
		//获取应用服务器的绝对地址
		ServletContext application = session.getServletContext();
		String rootPath = application.getRealPath("/");
		//做一个文件夹
		String dirName = "upload";
		String dirPath = rootPath + dirName;
		File dirFile = new File(dirPath);
		if(!dirFile.exists()){
			//创建文件夹
			dirFile.mkdir();
		}
		
		//转换req
		MultipartRequest request = (MultipartRequest) req;
		String cpath = this.uploadFile(request, "cphoto", dirPath,dirName);	//上传证件照文件
		u.setCardphoto(cpath);
		String wpath = this.uploadFile(request, "wphoto", dirPath,dirName);	//上传工作照文件
		u.setWorkphoto(wpath);
		
		//再保存创建人  创建时间
		//获取登陆用户
		Users loginUser = (Users) session.getAttribute("loginUser");
		u.setCreateby(loginUser.getId());
		u.setCreationdate(new Date());
		
		usersService.addUsers(u);
		
		
		
		return "redirect:toUserList.do";
	}
	
	
	private String uploadFile(MultipartRequest request,String formName,String dirPath,String dirName){
		String result = "";
		try {
			MultipartFile cfile = request.getFile(formName);
			//修改文件名
			String uuid = UUIDUtil.getUUID();
			String newFileName = uuid+cfile.getOriginalFilename().substring(cfile.getOriginalFilename().lastIndexOf("."));
			//文件上传地址
			String path = dirPath + "/" + newFileName;
			byte[] b = cfile.getBytes();
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(b);
			fos.flush();
			fos.close();
			//File.separator 自适应分隔符
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
	
	@RequestMapping("userview/{id}")
	public String userview(@PathVariable("id")int id,Model model){
		
		Users u = usersService.findById(id);
		
		model.addAttribute("u", u);
		return "forward:/WEB-INF/jsp/user/userview.jsp";
	}
	
	@RequestMapping("toUserModify.do")
	public String toUserModify(int id,Model model){
		Users u = usersService.findById(id);
		
		model.addAttribute("u", u);
		
		return "user/usermodify";
	}
	
	
	@RequestMapping("userModify.do")
	public String userModify(HttpServletRequest req,HttpSession session,Users u){
		
		//文件
		//获取应用服务器的绝对地址
		ServletContext application = session.getServletContext();
		String rootPath = application.getRealPath("/");
		//做一个文件夹
		String dirName = "upload";
		String dirPath = rootPath + dirName;
		File dirFile = new File(dirPath);
		if(!dirFile.exists()){
			//创建文件夹
			dirFile.mkdir();
		}
		
		
		
		//看看用户有没有上传图片
		//获取原来的User对象把
		Users old = usersService.findById(u.getId());
		
		MultipartRequest request = (MultipartRequest) req;
		
		MultipartFile cfile = request.getFile("cphoto");
		if(cfile.isEmpty()){
			//使用原来的图片
			u.setCardphoto(old.getCardphoto());
		}else{
			String newPath = this.uploadFile(request, "cphoto", dirPath, dirName);
			u.setCardphoto(newPath);
			//删除老照片
			File oldFile = new File(rootPath + old.getCardphoto());
			if(oldFile.exists()){
				oldFile.delete();
			}
		}
		
		
		MultipartFile wfile = request.getFile("wphoto");
		if(wfile.isEmpty()){
			//使用原来的图片
			u.setWorkphoto(old.getWorkphoto());
		}else{
			String newPath = this.uploadFile(request, "wphoto", dirPath, dirName);
			u.setWorkphoto(newPath);
			//删除老照片
			File oldFile = new File(rootPath + old.getWorkphoto());
			if(oldFile.exists()){
				oldFile.delete();
			}
		}
		//修改人 修改时间
		
		//获取登陆用户
		Users loginUser = (Users) session.getAttribute("loginUser");
		
		//修改人 修改时间
		u.setModifyby(loginUser.getId());
		
		u.setModifydate(new Date());
		
		usersService.updateUsers(u);
		
		return "redirect:toUserList.do";
		
	}
	
	
	@RequestMapping("checkCode.do")
	@ResponseBody		//
	public String checkCode(String code){
		int count = usersService.checkCode(code);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("count", count);
		return JSONObject.toJSONString(param);
	}
	
	@RequestMapping("userDelete.do")
	public String userDelete(int id){
		
		usersService.deleteUsers(id);
		
		return "redirect:toUserList.do";
		
		
	}
	
	@RequestMapping("toPwd.do")
	public String toPwd(HttpSession session,Model model){
		
		Users u = (Users) session.getAttribute("loginUser");
		
		Users user = usersService.findById(u.getId());
		
		model.addAttribute("user", user);
		
		return "user/passwordmodify";
		
	}
	
	@RequestMapping("updatePwd.do")
	@ResponseBody
	public String updatePwd(HttpSession session,Users users){
		
		Users u = new Users();
		
		u.setId(users.getId());
		
		u.setUserpassword(users.getUserpassword());
		
		u.setModifyby(users.getId());
		
		u.setModifydate(new Date());
		
		int count = usersService.updatePwd(u);
		
		return JSONObject.toJSONString(count);
		
	}
	// 局部异常处理
	// 也就是项目上线了 可能需要的一段代码
	// @ExceptionHandler(value={NullPointerException.class})
	// public String zb(){
	// return "401";
	// }
}
