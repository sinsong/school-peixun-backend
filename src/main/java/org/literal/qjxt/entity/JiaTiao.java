package org.literal.qjxt.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 假条
 * @author literal
 *
 */
public class JiaTiao implements Serializable {
	private Integer id;
	private String 	type;   // 请假类型 事假 | 病假
	/*
	enum Type {
	    事假，
	    病假
	} 
	 */
	private Date 	s_time;	// 开始时间
	private Date 	e_time;	// 结束时间
	private String 	reason; // 原因
	private String 	status; // 状态
	private Integer uid;    // 请假学生 id
	private Integer tid;    // 审批老师 id
	private String  phone;  // 手机号
	
	private static final long serialVersionUID = 9055018177286329522L;
	
	public JiaTiao() {
	}

	public JiaTiao(Integer id, String type, Date s_time, Date e_time, String reason, String status, Integer uid,
			Integer tid, String phone) {
		super();
		this.id = id;
		this.type = type;
		this.s_time = s_time;
		this.e_time = e_time;
		this.reason = reason;
		this.status = status;
		this.uid = uid;
		this.tid = tid;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getS_time() {
		return s_time;
	}

	public void setS_time(Date s_time) {
		this.s_time = s_time;
	}

	public Date getE_time() {
		return e_time;
	}

	public void setE_time(Date e_time) {
		this.e_time = e_time;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
