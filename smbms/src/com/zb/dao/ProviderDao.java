package com.zb.dao;

import java.util.List;
import java.util.Map;

import com.zb.entity.Bill;
import com.zb.entity.Provider;

public interface ProviderDao {
	
	/**
	 * 查询供应商
	 * @return
	 */
	public List<Provider> findProvider();
	
	/**
	 * 查询订单，模糊，分页
	 * @param params
	 * @return
	 */
	public List<Provider> findAllProvider(Map<String, Object> params);
	
	
	/**
	 * 查询订单总数
	 * @return
	 */
	public int findProviderCount(Map<String, Object> params);
	
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Provider findId(int id);
	
	/**
	 * 新增
	 * @param bill
	 * @return
	 */
	public int add(Provider p);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int del(int id);
	
	/**
	 * 修改
	 * @param bill
	 * @return
	 */
	public int upd(Provider p);
	
}	
