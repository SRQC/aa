package com.zb.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 订单实体类
 * @author asus
 *
 */
public class Bill {
 
    private int id;					//id
    
    private String billcode;		//订单编号
    
    private String productname;		//订单名称
    
    private String productdesc;		//订单描述
    
    private double productunit;		//订单单价
    
    private int productcount;		//订单数量
    
    private double totalprice;		//订单总价
    
    private int ispayment;			//是否支付
    
    private int createby;			//创建人
    
    @JSONField(format="yyyy-MM-dd")
    private Date creationdate;		//创建时间
    
    private int modifyby;			//修改人
    
    private Date modifydate;		//修改时间
    	
    private Provider provider;		//供应商

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
