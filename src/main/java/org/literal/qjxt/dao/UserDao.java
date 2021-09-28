package org.literal.qjxt.dao;

import org.literal.qjxt.entity.User;
import org.literal.qjxt.entity.UserInfo;

/**
 * 用户模块的持久类
 * @author literal
 *
 */
public interface UserDao {
	// 学生注册
	public abstract int addStu(User user);
	public abstract int addStuInfo(UserInfo info);
	// 教师注册
	public abstract int addTeacher(User user);
	public abstract int addTeacherInfo(UserInfo info);
	
	// 学生登录
	public abstract User stuLogin(User user);
	// 教师登录
	public abstract User teacherLogin(User user);
}
