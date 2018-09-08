package com.zb.dao;

import java.util.List;
import java.util.Map;

import com.zb.entity.Bill;

public interface BillDao {

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Bill> findBill(Map<String, Object> params);
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public int findBillCount(Map<String, Object> params);
	
	/**
	 * ����Id��ѯ
	 * @param id
	 * @return
	 */
	public Bill findId(int id);
	
	/**
	 * ����
	 * @param bill
	 * @return
	 */
	public int add(Bill bill);
	
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	public int del(int id);
	
	/**
	 * �޸�
	 * @param bill
	 * @return
	 */
	public int upd(Bill bill);
}
