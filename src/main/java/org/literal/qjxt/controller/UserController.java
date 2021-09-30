package org.literal.qjxt.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.literal.qjxt.entity.Param;
import org.literal.qjxt.entity.User;
import org.literal.qjxt.entity.UserInfo;
import org.literal.qjxt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户模块的处理
 * @author literal
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;

	// 学生/老师 登录注册
	/**
	 * 注册
	 * @param user 账号
	 * @param info 账号详情
	 * @param role 角色
	 * @return json
	 */
	@PostMapping("/register")
	@ResponseBody
	public Map<String, Object> register(@RequestBody Param param)
	{
		//System.out.println(param);
		User     	user = param.getUser();
		UserInfo 	info = param.getInfo();
		int 		role = param.getRole(); // 0 -> 学生 | 1 -> 教师
		
		switch(role)
		{
		case 0:		// 学生
			// TODO: 在前端里头记得传值 role: 0
			return userService.stuRegister(user, info);
		case 1:		// 教师
			return userService.teacherRegister(user, info);
		default:
			return null;
		}
	}
	
	@PostMapping("/login")
	@ResponseBody
	public Map<String, Object> login(@RequestBody Param param, HttpSession session)
	{
		User 	user = param.getUser();
		int 	role = param.getRole();
		
		switch(role)
		{
		case 0:		// 学生
			{
				Map<String, Object> result = userService.stuLogin(user);
				Integer status = (Integer) result.get("status");
				if (status == 0)
				{
					result.put("role", 0);
					// 登陆成功 保持登录状态
					session.setAttribute("user", result.get("user"));
					session.setAttribute("role", 0);
				}
				return result;
			}
		case 1:		// 教师
			{
				Map<String, Object> result = userService.teacherLogin(user);
				Integer status = (Integer) result.get("status");
				if (status == 0)
				{
					result.put("role", 1);
					session.setAttribute("user", result.get("user"));
					session.setAttribute("role", 1);
				}
				return result;
			}
		default:
			return null;
		}
	}
}
