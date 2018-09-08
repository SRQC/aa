package com.zb.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * ����ʵ����
 * @author asus
 *
 */
public class Bill {
 
    private int id;					//id
    
    private String billcode;		//�������
    
    private String productname;		//��������
    
    private String productdesc;		//��������
    
    private double productunit;		//��������
    
    private int productcount;		//��������
    
    private double totalprice;		//�����ܼ�
    
    private int ispayment;			//�Ƿ�֧��
    
    private int createby;			//������
    
    @JSONField(format="yyyy-MM-dd")
    private Date creationdate;		//����ʱ��
    
    private int modifyby;			//�޸���
    
    private Date modifydate;		//�޸�ʱ��
    	
    private Provider provider;		//��Ӧ��

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBillcode() {
		return billcode;
	}

	public void setBillcode(String billcode) {
		this.billcode = billcode;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdesc() {
		return productdesc;
	}

	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}

	public double getProductunit() {
		return productunit;
	}

	public void setProductunit(double productunit) {
		this.productunit = productunit;
	}

	public int getProductcount() {
		return productcount;
	}

	public void setProductcount(int productcount) {
		this.productcount = productcount;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public int getIspayment() {
		return ispayment;
	}

	public void setIspayment(int ispayment) {
		this.ispayment = ispayment;
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

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
    
    
}
