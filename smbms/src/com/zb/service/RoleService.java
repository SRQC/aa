package com.zb.service;

import java.util.List;
import java.util.Map;

import com.zb.entity.Role;

public interface RoleService {
	
	/**
	 * ��ѯ����Ȩ��,��ѯ�û�
	 * @return
	 */
	public List<Role> findRoles();
	
	/**
	 * ��ѯ�û���¼��
	 * @param param 
	 * @return
	 */
	public int findRoleCount();
	
	/**
	 * �����û�
	 * @param u
	 * @return
	 */
	public int addRole(Role role);
	
	/**
	 * ����id��ѯ����
	 * @param id
	 * @return
	 */
	public Role findById(int id);
	
	/**
	 * �޸��û�
	 * @param u
	 * @return
	 */
	public int updateRole(Role role);
	
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	public int deleteRole(int id);
	
	/**
	 * ��֤�û������Ƿ����
	 * @param code
	 * @return
	 */
	public int checkCode(String code);

}
