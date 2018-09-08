package com.zb.dao;

import java.util.List;
import java.util.Map;

import com.zb.entity.Bill;

public interface BillDao {

	/**
	 * 查询订单
	 * @return
	 */
	public List<Bill> findBill(Map<String, Object> params);
	
	/**
	 * 查询订单总数
	 * @return
	 */
	public int findBillCount(Map<String, Object> params);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Bill findId(int id);
	
	/**
	 * 新增
	 * @param bill
	 * @return
	 */
	public int add(Bill bill);
	
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
	public int upd(Bill bill);
}
