package org.literal.qjxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.literal.qjxt.dao.JiaTiaoDao;
import org.literal.qjxt.entity.JiaTiao;
import org.literal.qjxt.entity.User;
import org.literal.qjxt.service.IJiaTiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JiaTiaoService implements IJiaTiaoService {
	
	@Autowired
	private JiaTiaoDao dao;

	@Override
	public Map<String, Object> submitJiaTiao(JiaTiao jt, User user, Integer role) {
		// 判断登录状态
		Map<String, Object> result = new HashMap<String, Object>();
		if (user == null || role != 0)
		{
			result.put("status", 1);
			result.put("msg", "未登录或者登录用户不是学生");
			return result;
		}
		// 登陆学生的id填充到假条中
		jt.setUid(user.getId());
		// 插入假条
		int row = dao.addJiaTiao(jt);
		if (row > 0)
		{
			result.put("status", 0);
			result.put("msg", "请假申请 提交成功");
		}
		return result;
	}

	@Override
	public Map<String, Object> stuQueryJiaTiao(User user, Integer role) {
		// 判断登录状态
		Map<String, Object> result = new HashMap<String, Object>();
		if (user == null || role != 0)
		{
			result.put("status", 1);
			result.put("msg", "未登录或者登录用户不是学生");
			return result;
		}
		List<JiaTiao> list = dao.stuSearchJT(user.getId());
		result.put("status", 0);
		result.put("msg", "查询成功");
		result.put("data", list);
		return result;
	}

	@Override
	public Map<String, Object> teacherQueryJiaTiao(User user, Integer role) {
		// 判断登录状态
		Map<String, Object> result = new HashMap<String, Object>();
		if (user == null || role != 1)
		{
			result.put("status", 1);
			result.put("msg", "未登录或者登录用户不是教师");
			return result;
		}
		List<JiaTiao> list = dao.teacherSearchJT(user.getId());
		result.put("status", 0);
		result.put("msg", "查询成功");
		result.put("data", list);
		return result;
	}

	@Override
	public Map<String, Object> teacherUpdateJiaTiao(User user, Integer role, Integer jid, String status) {
		// 判断登录状态
		Map<String, Object> result = new HashMap<String, Object>();
		if (user == null || role != 1)
		{
			result.put("status", 1);
			result.put("msg", "未登录或者登录用户不是教师");
			return result;
		}
		// 根据假条id和老师id修改假条状态
		int row = dao.teacherUpdateJiaTiao(user.getId(), jid, status);
		if (row > 0)
		{
			result.put("status", 0);
			result.put("msg", "修改假条状态成功");
		}
		else
		{
			result.put("status", 1);
			result.put("msg", "修改假条状态失败");
		}
		return result;
	}

}
