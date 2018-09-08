package com.zb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zb.dao.ProviderDao;
import com.zb.entity.Bill;
import com.zb.entity.Provider;
import com.zb.service.ProviderServices;

@Service
public class ProviderServicesImpl implements ProviderServices{
	
	@Resource
	private ProviderDao providerDao;
	
	public List<Provider> findProvider() {
	
		return providerDao.findProvider();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int add(Provider p) {
		
		return providerDao.add(p);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int del(int id) {
		
		return providerDao.del(id);
	}
	
	
	@Transactional(readOnly=true)
	public Provider findId(int id) {
		
		return providerDao.findId(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int upd(Provider p) {
		
		return providerDao.upd(p);
	}
	
	@Transactional(readOnly=true)
	public List<Provider> findAllProvider(String queryProName,String queryProCode, int currentPage) {

		Map<String, Object> params = new HashMap<String,Object>();
		
		params.put("start",(currentPage-1)*4 );
		
		params.put("size", 4);
		
		if (queryProName !=null && !"".equals(queryProName)) {
			
			params.put("queryProName",queryProName);
		}
		
		if (queryProCode !=null && !"".equals(queryProCode)) {
			
			params.put("queryProCode",queryProCode);
		}
		
		return providerDao.findAllProvider(params);
	}
	
	@Transactional(readOnly=true)
	public int findProviderCount(String queryProName, String queryProCode) {
		
		Map<String, Object> params = new HashMap<String,Object>();
		
		if (queryProName !=null && !"".equals(queryProName)) {
			
			params.put("queryProName",queryProName);
		}
		
		if (queryProCode !=null && !"".equals(queryProCode)) {
			
			params.put("queryProCode",queryProCode);
		}

		
		return providerDao.findProviderCount(params);
	}
	
	
	
}
