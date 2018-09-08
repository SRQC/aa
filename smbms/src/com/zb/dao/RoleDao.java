package com.zb.dao;

import java.util.List;
import java.util.Map;

import com.zb.entity.Role;
import com.zb.entity.Users;

public interface RoleDao {
	
	/**
	 * 查询所有权限
	 * @return
	 */
	public List<Role> findRoles();
	
	
	/**
	 * 查询用户记录数
	 * @param param 
	 * @return
	 */
	public int findRoleCount();
	
	/**
	 * 保存用户
	 * @param u
	 * @return
	 */
	public int addRole(Role role);
	
	/**
	 * 根据id查询对象
	 * @param id
	 * @return
	 */
	public Role findById(int id);
	
	/**
	 * 修改用户
	 * @param u
	 * @return
	 */
	public int updateRole(Role role);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int deleteRole(int id);
	
	/**
	 * 验证用户编码是否存在
	 * @param code
	 * @return
	 */
	public int checkCode(String code);
	
	
}
