package com.zb.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.Users;

public interface UsersService {
	/**
	 * ��½
	 * @param username
	 * @param password
	 * @return
	 */
	public Users login(@Param("username")String username,@Param("password")String password);
	
	/**
	 * ��ѯ�û�
	 * @param queryUserRole 
	 * @param queryname 
	 * @param currentPage 
	 * @return
	 */
	public List<Users> findUsers(String queryname, String queryUserRole, int currentPage);
	
	/**
	 * ��ѯ�û���¼��
	 * @param queryUserRole 
	 * @param queryname 
	 * @param currentPage 
	 * @return
	 */
	public int findUsersCount(String queryname, String queryUserRole);
	
	/**
	 * �����û�
	 * @param u
	 * @return
	 */
	public int addUsers(Users u);
	
	
	/**
	 * ����id��ѯ����
	 * @param id
	 * @return
	 */
	public Users findById(int id);
	
	/**
	 * �޸��û�
	 * @param u
	 * @return
	 */
	public int updateUsers(Users u);
	
	
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	public int deleteUsers(int id);
	
	/**
	 * ��֤�û������Ƿ����
	 * @param code
	 * @return
	 */
	public int checkCode(String code);
	
	/**
	 * �޸ĵ�ǰ�û�����
	 * @param users
	 * @return
	 */
	public int updatePwd(Users users);
}
