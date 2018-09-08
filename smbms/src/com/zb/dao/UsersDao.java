package com.zb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.Users;

public interface UsersDao {
	
	/**
	 * ��½
	 * @param username
	 * @param password
	 * @return
	 */
	public Users login(@Param("username")String username,@Param("password")String password);
	
	/**
	 * ��ѯ�û�
	 * @param param 
	 * @return
	 */
	public List<Users> findUsers(Map<String, Object> param);
	
	/**
	 * ��ѯ�û���¼��
	 * @param param 
	 * @return
	 */
	public int findUsersCount(Map<String, Object> param);
	
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
