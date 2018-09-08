package com.zb.service;

import java.util.List;
import java.util.Map;

import com.zb.entity.Provider;

public interface ProviderServices {
	
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
	public List<Provider> findAllProvider(String queryProName,String queryProCode,int currentPage);
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public int findProviderCount(String queryProName,String queryProCode);
	
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
