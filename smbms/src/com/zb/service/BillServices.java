package com.zb.service;

import java.util.List;
import java.util.Map;

import com.zb.entity.Bill;

public interface BillServices {
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Bill> findBill(String queryProductName, int queryProviderId, int queryIsPayment, int currentPage);
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public int findBillCount(String queryProductName, int queryProviderId, int queryIsPayment);
	
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
