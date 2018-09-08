package com.zb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zb.dao.RoleDao;
import com.zb.entity.Role;
import com.zb.service.RoleService;
import com.zb.util.MybatisUtil;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	@Resource
	private RoleDao roleDao;
	
	
	public List<Role> findRoles() {
		return roleDao.findRoles();
	}


	public int addRole(Role role) {
		
		return roleDao.addRole(role);
	}


	public int checkCode(String code) {
		
		return roleDao.checkCode(code);
	}


	public int deleteRole(int id) {
		
		return roleDao.deleteRole(id);
	}


	public Role findById(int id) {
		
		return roleDao.findById(id);
	}


	public int findRoleCount() {
		
		return roleDao.findRoleCount();
	}


	public int updateRole(Role role) {

		return roleDao.updateRole(role);
	}


}
