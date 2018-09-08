package com.zb.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 供应商
 * @author asus
 *
 */
public class Provider {
	    
	private int id; 			//id
	 
	private String procode;		//供应商编号
	
	private String proname;		//供应商名称
	
	private String prodesc;		//供应商描述
	
	private String procontact;	//供应商联系人
	
	private String prophone;	//联系电话
	
	private String proaddress;	//联系地址
	
	private String profax;		//传真
	
	private int createby;		//创建人
	
	@JSONField(format="yyyy-MM-dd")
	private Date creationdate;	//创建时间
	
	private int modifyby;		//修改人
	
	private Date modifydate;	//修改时间
	
	private String cardphoto;	//企业营业执照
	
	private String workphoto;	//组织机构代码证
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProcode() {
		return procode;
	}

	public void setProcode(String procode) {
		this.procode = procode;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getProdesc() {
		return prodesc;
	}

	public void setProdesc(String prodesc) {
		this.prodesc = prodesc;
	}

	public String getProcontact() {
		return procontact;
	}

	public void setProcontact(String procontact) {
		this.procontact = procontact;
	}

	public String getProphone() {
		return prophone;
	}

	public void setProphone(String prophone) {
		this.prophone = prophone;
	}

	public String getProaddress() {
		return proaddress;
	}

	public void setProaddress(String proaddress) {
		this.proaddress = proaddress;
	}

	public String getProfax() {
		return profax;
	}

	public void setProfax(String profax) {
		this.profax = profax;
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
