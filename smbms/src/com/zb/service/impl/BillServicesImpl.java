package com.zb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zb.dao.BillDao;
import com.zb.entity.Bill;
import com.zb.service.BillServices;

@Service
public class BillServicesImpl implements BillServices{
	
	@Resource
	private BillDao billDao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int add(Bill bill) {
		
		return billDao.add(bill);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int del(int id) {
		
		return billDao.del(id);
	}
	
	@Transactional(readOnly=true)
	public List<Bill> findBill(String queryProductName, int queryProviderId,int queryIsPayment, int currentPage) {
		
		Map<String, Object> params = new HashMap<String,Object>();
		
		params.put("start",(currentPage-1)*4 );
		
		params.put("size", 4);
		
		if (queryProductName !=null && !"".equals(queryProductName)) {
			
			params.put("queryProductName",queryProductName);
		}
		
		if (queryProviderId !=0) {
			
			params.put("queryProviderId",queryProviderId);
		}
		
		if (queryIsPayment !=0) {
			
			params.put("queryIsPayment",queryIsPayment);
		}
		return billDao.findBill(params);
	}
	
	@Transactional(readOnly=true)
	public int findBillCount(String queryProductName, int queryProviderId,int queryIsPayment) {
		
		Map<String, Object> params = new HashMap<String,Object>();
		
		if (queryProductName !=null && "".equals(queryProductName)) {
			
			params.put("queryProductName",queryProductName);
		}
		
		if (queryProviderId !=0) {
			
			params.put("queryProviderId",queryProviderId);
		}
		
		if (queryIsPayment !=0) {
			
			params.put("queryIsPayment",queryIsPayment);
		}
		
		return billDao.findBillCount(params);
	}
	
	@Transactional(readOnly=true)
	public Bill findId(int id) {
		
		return billDao.findId(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int upd(Bill bill) {
		
		return billDao.upd(bill);
	}

}
