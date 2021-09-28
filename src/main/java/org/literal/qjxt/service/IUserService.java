package org.literal.qjxt.service;

import java.util.Map;

import org.literal.qjxt.entity.User;
import org.literal.qjxt.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户模块业务层接口
 * @author literal
 *
 */
public interface IUserService {	
	// 学生注册
	public abstract Map<String, Object> stuRegister(User user, UserInfo info);
	// 教师注册
	public abstract Map<String, Object> teacherRegister(User user, UserInfo info);
	
	// 学生登录
	public abstract Map<String, Object> stuLogin(User user);
	// 教师登录
	public abstract Map<String, Object> teacherLogin(User user);
}
