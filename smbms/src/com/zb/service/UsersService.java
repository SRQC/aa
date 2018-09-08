package com.zb.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.Users;

public interface UsersService {
	/**
	 * 登陆
	 * @param username
	 * @param password
	 * @return
	 */
	public Users login(@Param("username")String username,@Param("password")String password);
	
	/**
	 * 查询用户
	 * @param queryUserRole 
	 * @param queryname 
	 * @param currentPage 
	 * @return
	 */
	public List<Users> findUsers(String queryname, String queryUserRole, int currentPage);
	
	/**
	 * 查询用户记录数
	 * @param queryUserRole 
	 * @param queryname 
	 * @param currentPage 
	 * @return
	 */
	public int findUsersCount(String queryname, String queryUserRole);
	
	/**
	 * 保存用户
	 * @param u
	 * @return
	 */
	public int addUsers(Users u);
	
	
	/**
	 * 根据id查询对象
	 * @param id
	 * @return
	 */
	public Users findById(int id);
	
	/**
	 * 修改用户
	 * @param u
	 * @return
	 */
	public int updateUsers(Users u);
	
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int deleteUsers(int id);
	
	/**
	 * 验证用户编码是否存在
	 * @param code
	 * @return
	 */
	public int checkCode(String code);
	
	/**
	 * 修改当前用户密码
	 * @param users
	 * @return
	 */
	public int updatePwd(Users users);
}
