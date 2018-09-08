package com.zb.dao;

import java.util.List;
import java.util.Map;

import com.zb.entity.Bill;
import com.zb.entity.Provider;

public interface ProviderDao {
	
	/**
	 * ��ѯ��Ӧ��
	 * @return
	 */
	public List<Provider> findProvider();
	
	/**
	 * ��ѯ������ģ������ҳ
	 * @param params
	 * @return
	 */
	public List<Provider> findAllProvider(Map<String, Object> params);
	
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public int findProviderCount(Map<String, Object> params);
	
	
	/**
	 * ����Id��ѯ
	 * @param id
	 * @return
	 */
	public Provider findId(int id);
	
	/**
	 * ����
	 * @param bill
	 * @return
	 */
	public int add(Provider p);
	
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
	public int upd(Provider p);
	
}	
