package org.literal.qjxt.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.literal.qjxt.entity.JiaTiao;
import org.literal.qjxt.entity.User;
import org.literal.qjxt.service.IJiaTiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 请假相关业务
 * @author literal
 *
 */
@Component
@RequestMapping("/jt")
public class JiaTiaoController {
	@Autowired
	private IJiaTiaoService service;
	
	/**
	 * 学生提交假条
	 */
	@PostMapping("/addjt")
	@ResponseBody
	public Map<String, Object> submitJiaTiao(@RequestBody JiaTiao jt, HttpSession session)
	{
		// 判断登录和学生端
		User user = (User) session.getAttribute("user");
		Integer role = (Integer) session.getAttribute("role");
		
		return service.submitJiaTiao(jt, user, role);
	}
	
	/**
	 * 学生查询假条
	 */
	@GetMapping("/stu/searchjt")
	@ResponseBody
	public Map<String, Object> stuSearchJiaTiao(HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		Integer role = (Integer) session.getAttribute("role");
		
		return service.stuQueryJiaTiao(user, role);
	}
	
	/**
	 * 老师查询假条
	 */
	@GetMapping("/teacher/searchjt")
	@ResponseBody
	public Map<String, Object> teacherSearchJiaTiao(HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		Integer role = (Integer) session.getAttribute("role");
		
		return service.teacherQueryJiaTiao(user, role);
	}
	
	/**
	 * 老师修改假条状态
	 */
	@GetMapping("/teacher/updatejt")
	@ResponseBody
	public Map<String, Object> updateJiaTiaoStatus(String status, Integer jid, HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		Integer role = (Integer) session.getAttribute("role");
		
		return service.teacherUpdateJiaTiao(user, role, jid, status);
	}
}
