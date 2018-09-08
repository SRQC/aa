package com.zb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zb.dao.UsersDao;
import com.zb.entity.Users;
import com.zb.service.UsersService;
import com.zb.util.MybatisUtil;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

	@Resource
	private UsersDao usersDao;

	public Users login(String username, String password) {
		return usersDao.login(username, password);
	}

	public List<Users> findUsers(String queryname, String queryUserRole,
			int currentPage) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", (currentPage - 1) * 4);
		param.put("size", 4);

		if (queryname != null && !"".equals(queryname)) {
			param.put("queryname", queryname);
		}
		if (!"0".equals(queryUserRole)) {
			param.put("queryUserRole", queryUserRole);
		}

		List<Users> list = usersDao.findUsers(param);
		return list;
	}

	public int findUsersCount(String queryname, String queryUserRole) {

		Map<String, Object> param = new HashMap<String, Object>();

		if (queryname != null && !"".equals(queryname)) {
			param.put("queryname", queryname);
		}
		if (!"0".equals(queryUserRole)) {
			param.put("queryUserRole", queryUserRole);
		}

		int count = usersDao.findUsersCount(param);

		return count;
	}

	public int addUsers(Users u) {

		return usersDao.addUsers(u);
	}

	public Users findById(int id) {

		return usersDao.findById(id);
	}

	public int updateUsers(Users u) {

		return usersDao.updateUsers(u);
	}

	public int deleteUsers(int id) {

		return usersDao.deleteUsers(id);
	}

	public int checkCode(String code) {
		return usersDao.checkCode(code);
	}

	public int updatePwd(Users users) {
		
		return usersDao.updatePwd(users);
	}

}
