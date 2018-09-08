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

public class UserAddServlet extends HttpServlet {

	private UsersService service = new UsersServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//1.����FileItemFactory����
			FileItemFactory factory = new DiskFileItemFactory();
			//2.����ServletFileUpload����
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			//3.����request
			List<FileItem> list = fileUpload.parseRequest(request);
			Users u = new Users();
			for(FileItem fi : list){
				//�ж�����ͨ�������ļ���
				if(fi.isFormField()){
					//��ͨ
					//��ȡ����name����
					String formName = fi.getFieldName();
					if("userCode".equals(formName)){
						u.setUsercode(fi.getString("utf-8"));
					}else if("userName".equals(formName)){
						u.setUsername(fi.getString("utf-8"));
					}else if("userPassword".equals(formName)){
						u.setUserpassword(fi.getString("utf-8"));
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
					//�ļ�
					//��ȡӦ�÷������ľ��Ե�ַ
					ServletContext application = this.getServletContext();
					String rootPath = application.getRealPath("/");
					//��һ���ļ���
					String dirName = "upload";
					String dirPath = rootPath + dirName;
					File dirFile = new File(dirPath);
					if(!dirFile.exists()){
						//�����ļ���
						dirFile.mkdir();
					}
					//�ϴ����ļ���
					String fileName = fi.getName();
					//��չ1���޸��ļ�������ֹ������
					String uuid = UUIDUtil.getUUID();
					String newFileName = uuid + fileName.substring(fileName.lastIndexOf("."));
					
					
					//�ϴ����ļ�·��
					String filePath = dirPath + "/" +newFileName;
					
					//��ȡ�ϴ����ļ�
					InputStream is = fi.getInputStream();
					byte[] b = new byte[(int) fi.getSize()];
					is.read(b,0,b.length);
					
					FileOutputStream fos = new FileOutputStream(filePath);
					fos.write(b);
					fos.flush();
					fos.close();
					
					//��ȡ����
					String formName = fi.getFieldName();
					if("cphoto".equals(formName)){
						u.setCardphoto(dirName + "/" + newFileName);
					}else if("wphoto".equals(formName)){
					
						u.setWorkphoto(dirName + "/" + newFileName);
					}
				}
			}
			//��ȡ��½�û�
			HttpSession session = request.getSession();
			Users loginUser = (Users) session.getAttribute("loginUser");
			u.setCreateby(loginUser.getId());
			u.setCreationdate(new Date());
			
			service.addUsers(u);
			//��ת����ѯȫ��
			request.getRequestDispatcher("toUserlistServlet").forward(request, response);
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
