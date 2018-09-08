package com.zb.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zb.entity.Role;
import com.zb.entity.Users;
import com.zb.service.UsersService;
import com.zb.service.impl.UsersServiceImpl;
import com.zb.util.UUIDUtil;

public class UserModifyServlet extends HttpServlet {

	private UsersService service = new UsersServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//1.创建FileItemFactory对象
			FileItemFactory factory = new DiskFileItemFactory();
			//2.创建ServletFileUpload对象
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			//3.解析request
			List<FileItem> list = fileUpload.parseRequest(request);
			Users u = null;
			
			for(FileItem fi : list){
				if(fi.isFormField()){
					//普通
					//普通
					//获取表单的name属性
					String formName = fi.getFieldName();
					if("id".equals(formName)){
						u = service.findById(Integer.parseInt(fi.getString("utf-8")));
					}else if("userName".equals(formName)){
						u.setUsername(fi.getString("utf-8"));
					}else if("gender".equals(formName)){
						u.setGender(Integer.parseInt(fi.getString("utf-8")));
					}else if("birthday".equals(formName)){
						String date = fi.getString("utf-8");
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						u.setBirthday(sdf.parse(date));
						
					}else if("phone".equals(formName)){
						u.setPhone(fi.getString("utf-8"));
					}else if("address".equals(formName)){
						u.setAddress(fi.getString("utf-8"));
					}else if("userRole".equals(formName)){
						Role r = new Role();
						r.setId(Integer.parseInt(fi.getString("utf-8")));
						u.setRole(r);
					}
					
					
				}else{
					//文件
					//获取服务器的绝对地址
					ServletContext application = this.getServletContext();
					String rootPath = application.getRealPath("/");
					String dirName = "upload";
					
					//上传文件
					String filename = fi.getName();
					if(filename != null && !"".equals(filename)){
						//表示用户上传了文件
						InputStream is = fi.getInputStream();
						byte[] b = new byte[(int) fi.getSize()];
						is.read(b, 0, b.length);
						
						//扩展1：修改文件名（防止重名）
						String uuid = UUIDUtil.getUUID();
						String newFileName = uuid + filename.substring(filename.lastIndexOf("."));
						
						String filePath = rootPath + dirName + "/" + newFileName;
						FileOutputStream fos = new FileOutputStream(filePath);
						
						fos.write(b);
						fos.flush();
						fos.close();
						
						//老文件需要删除(由于有2个图片  需要知道 删除哪个图片)
						String formName = fi.getFieldName();
						if("cphoto".equals(formName)){
							//移除证件照
							String cardphotoPath = rootPath + u.getCardphoto();
							File f = new File(cardphotoPath);
							if(f.exists()){
								f.delete();
							}
							//保存新的路径
							u.setCardphoto(dirName+"/"+newFileName);
							
						}else{
							//移除工作照
							String workphotoPath = rootPath + u.getWorkphoto();
							File f = new File(workphotoPath);
							if(f.exists()){
								f.delete();
							}
							//保存新的路径
							u.setWorkphoto(dirName+"/"+newFileName);
						}
						
					}
					
					
					
				}
			}
			//获取登陆用户
			HttpSession session = request.getSession();
			Users loginUser = (Users) session.getAttribute("loginUser");
			
			//修改人 修改时间
			u.setModifyby(loginUser.getId());
			
			u.setModifydate(new Date());
			
			service.updateUsers(u);
			//去查询
			response.sendRedirect("toUserlistServlet");
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
