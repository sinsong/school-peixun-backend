package org.literal.qjxt.entity;

public class Param {
	private User user;
	private UserInfo info;
	private int role;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserInfo getInfo() {
		return info;
	}
	public void setInfo(UserInfo info) {
		this.info = info;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Param [user=" + user + ", info=" + info + ", role=" + role + "]";
	}
	
	
}
