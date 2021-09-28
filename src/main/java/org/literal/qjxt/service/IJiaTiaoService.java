package org.literal.qjxt.service;

import java.util.Map;

import org.literal.qjxt.entity.JiaTiao;
import org.literal.qjxt.entity.User;

/**
 * 假条模块业务接口
 * @author literal
 *
 */
public interface IJiaTiaoService {
	// 学生提交假条
	public abstract Map<String, Object> submitJiaTiao(JiaTiao jt, User user, Integer role);
	// 学生查询假条
	public abstract Map<String, Object> stuQueryJiaTiao(User user, Integer role);
	// 老师查询假条
	public abstract Map<String, Object> teacherQueryJiaTiao(User user, Integer role);
	// 老师修改假条
	public abstract Map<String, Object> teacherUpdateJiaTiao(User user, Integer role, Integer jid, String status);
}
