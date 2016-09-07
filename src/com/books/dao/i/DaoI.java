package com.books.dao.i;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DaoI {
	/** 
	 * ���ӡ�ɾ�����޸�
	 * @throws Exception 
	 * 
	 */
	public boolean exec(String sql,Object...obj) throws Exception;
	/** 
	 * ��ѯ
	 * @throws SQLException 
	 * 
	 */
	public List<Map<String, Object>> query(String sql,Object...obj) throws SQLException;
}
