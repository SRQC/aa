package com.zb.entity;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户  对应smbms_user表
 * @author Administrator
 *
 */
public class Users {

    
    private int id;						//id
    
    private int smbid;					//没有用id
    @NotEmpty
    private String usercode;			//用户编码
    @NotEmpty
    @Length(min=4,max=10)
    private String username;			//用户名
    
    private String userpassword;		//密码
    
    private int gender;					//性别 1男 2女
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format="yyyy-MM-dd")
    private Date birthday;				//生日
    
    private String phone;				//电话
    
    private String address;				//地址
    
    private Role role;					//权限id
    
    private int createby;				//创建人
    
    private Date creationdate;			//创建时间
    
    private int modifyby;				//修改人
    
    private Date modifydate;			//修改时间
    
    private int age;
    
    private String cardphoto;			//证件照
    
    private String workphoto;			//工作照
    

	@SuppressWarnings("deprecation")
	public int getAge() {
		Date d = new Date();
//		int diff = d.getYear() - this.birthday.getYear();
		
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		
		Calendar c1 = Calendar.getInstance();
		c1.setTime(this.birthday);
		
		int diff = c.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
		
		return diff;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSmbid() {
		return smbid;
	}

	public void setSmbid(int smbid) {
		this.smbid = smbid;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getCreateby() {
		return createby;
	}

	public void setCreateby(int createby) {
		this.createby = createby;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public int getModifyby() {
		return modifyby;
	}

	public void setModifyby(int modifyby) {
		this.modifyby = modifyby;
	}

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public String getCardphoto() {
		return cardphoto;
	}

	public void setCardphoto(String cardphoto) {
		this.cardphoto = cardphoto;
	}

	public String getWorkphoto() {
		return workphoto;
	}

	public void setWorkphoto(String workphoto) {
		this.workphoto = workphoto;
	}
    
}
