package org.literal.qjxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.literal.qjxt.entity.JiaTiao;

/**
 * 假条模块持久类
 * @author literal
 *
 */
public interface JiaTiaoDao {
	// 添加假条
	public abstract int addJiaTiao(JiaTiao jt);
	
	/**
	 * 学生查询假条
	 * @param uid 登录学生 id
	 * @return 假条列表
	 */
	public abstract List<JiaTiao> stuSearchJT(Integer uid);
	
	/**
	 * 老师查询假条
	 * @param tid 登录老师 id
	 * @return 借条列表
	 */
	public abstract List<JiaTiao> teacherSearchJT(Integer tid);
	
	/**
	 * 老师修改假条状态
	 * @param tid 老师id
	 * @param jid 假条id
	 * @param status 新状态
	 * @return 影响的行数
	 */
	public abstract int teacherUpdateJiaTiao(@Param("tid") Integer tid, @Param("jit") Integer jid, @Param("status") String status);
}
