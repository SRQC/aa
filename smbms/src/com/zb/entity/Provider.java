package com.zb.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * ��Ӧ��
 * @author asus
 *
 */
public class Provider {
	    
	private int id; 			//id
	 
	private String procode;		//��Ӧ�̱��
	
	private String proname;		//��Ӧ������
	
	private String prodesc;		//��Ӧ������
	
	private String procontact;	//��Ӧ����ϵ��
	
	private String prophone;	//��ϵ�绰
	
	private String proaddress;	//��ϵ��ַ
	
	private String profax;		//����
	
	private int createby;		//������
	
	@JSONField(format="yyyy-MM-dd")
	private Date creationdate;	//����ʱ��
	
	private int modifyby;		//�޸���
	
	private Date modifydate;	//�޸�ʱ��
	
	private String cardphoto;	//��ҵӪҵִ��
	
	private String workphoto;	//��֯��������֤
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
