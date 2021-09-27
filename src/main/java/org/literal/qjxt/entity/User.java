package org.literal.qjxt.entity;

import java.io.Serializable;

/**
 * 用户实体 映射 学生 | 教师
 * @author literal
 *
 */
public class User implements Serializable {
	private Integer id;      // 主键
	private String  account; // 账号
	private String  pwd;     // 密码
	
	private static final long serialVersionUID = -413428804912391953L;
	
	public User() {
	}

	public User(Integer id, String account, String pwd) {
		super();
		this.id = id;
		this.account = account;
		this.pwd = pwd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", pwd=" + pwd + "]";
	}
}
