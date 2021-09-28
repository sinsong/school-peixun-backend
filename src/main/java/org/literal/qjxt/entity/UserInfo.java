package org.literal.qjxt.entity;

import java.io.Serializable;

/**
 * 详情的实体类 映射 学生 | 教师 的详情
 * @author literal
 *
 */
public class UserInfo implements Serializable{
	private Integer id;
	private String 	name; 	// 姓名
	private String 	clazz; 	//班级
	private Integer uid; 	// 关联的用户id
	
	private static final long serialVersionUID = -7481283196488173710L;
	
	public UserInfo() {
	}
	
	public UserInfo(Integer id, String name, String clazz, Integer uid) {
		super();
		this.id = id;
		this.name = name;
		this.clazz = clazz;
		this.uid = uid;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", clazz=" + clazz + ", uid=" + uid + "]";
	}
	
}
