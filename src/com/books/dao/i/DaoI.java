package com.books.dao.i;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DaoI {
	/** 
	 * 增加、删除、修改
	 * @throws Exception 
	 * 
	 */
	public boolean exec(String sql,Object...obj) throws Exception;
	/** 
	 * 查询
	 * @throws SQLException 
	 * 
	 */
	public List<Map<String, Object>> query(String sql,Object...obj) throws SQLException;
}
