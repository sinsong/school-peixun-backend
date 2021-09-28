package org.literal.qjxt.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.literal.qjxt.dao.UserDao;
import org.literal.qjxt.entity.User;
import org.literal.qjxt.entity.UserInfo;
import org.literal.qjxt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public Map<String, Object> stuRegister(User user, UserInfo info) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 判断账号是否已存在
		if (userDao.stuLogin(user) != null)
		{
			result.put("status", 1);
			result.put("msg", "账号已存在");
			return result;
		}
		
		int row = userDao.addStu(user);
		if (row > 0)
		{
			// 添加成功
			info.setUid(user.getId());
			userDao.addStuInfo(info);
			// 0 -> 成功
			result.put("status", 0);
			result.put("msg", "注册成功");
		}
		else
		{
			// 1 -> 失败
			result.put("status", 1);
			result.put("msg", "注册失败");
		}
		return result;
	}

	@Override
	public Map<String, Object> teacherRegister(User user, UserInfo info) {
		Map<String, Object> result = new HashMap<String, Object>();
		if(userDao.teacherLogin(user) != null)
		{
			result.put("status", 1);
			result.put("msg", "账号已存在");
			return result;
		}
		int row = userDao.addTeacher(user);
		if (row > 0)
		{
			info.setUid(user.getId());
			userDao.addTeacherInfo(info);
			result.put("status", 0);
			result.put("msg", "注册成功");
		}
		else
		{
			result.put("status", 1);
			result.put("msg", "注册失败");
		}
		return result;
	}

	@Override
	public Map<String, Object> stuLogin(User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		User loggedUser = userDao.stuLogin(user);
		if (loggedUser != null)
		{
			result.put("status", 0);
			result.put("msg", "登录成功");
			result.put("user", loggedUser);
		}
		else
		{
			result.put("status", 1);
			result.put("msg", "登录失败");
		}
		return result;
	}

	@Override
	public Map<String, Object> teacherLogin(User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		User loggedUser = userDao.teacherLogin(user);
		if (loggedUser != null)
		{
			result.put("status", 0);
			result.put("msg", "登录成功");
			result.put("user", loggedUser);
		}
		else
		{
			result.put("status", 1);
			result.put("msg", "登录失败");
		}
		return result;
	}

}
