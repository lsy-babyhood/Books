package com.books.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.books.dao.i.DaoI;

public class DaoImpl implements DaoI{
	static Connection conn = null;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			String url = "jdbc:mysql://127.0.0.1:3306/library?useUnocode=true&characterEncoding=utf-8";
			String userName = "root";
			String password = "";
			conn = java.sql.DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���ӡ��޸ġ�ɾ��
	 * sql
	 * obj��һ�����飬��Ӧsql��ġ�����
	 * @throws Exception 
	 * 
	 */

	@Override
	public boolean exec(String sql, Object... obj) throws Exception {
		PreparedStatement preparedStatement = null;
		try {
			//����Ԥ�������
			preparedStatement = conn.prepareStatement(sql);
			//������������ģ�
			for (int i = 0; i < obj.length; i++) {
				preparedStatement.setObject((i+1), obj[i]);
			}
			//ִ��sql��䣬����Ӱ��������
			int size = preparedStatement.executeUpdate();
			if (size==0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			throw e;
		}finally {
			preparedStatement.close();
		}

	}
	@Override
	public List<Map<String, Object>> query(String sql, Object... obj) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				preparedStatement.setObject((i+1), obj[i]);
			}
			ResultSet result = preparedStatement.executeQuery();
			ResultSetMetaData metaData = result.getMetaData();
			List<String> column = new ArrayList<>();
			for (int i = 0; i < metaData.getColumnCount(); i++) {
				column.add(metaData.getColumnName(i));
			}
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map = null;
			while(result.next()){
				map = new HashMap<>();
				for (int i = 0; i < column.size(); i++) {
					map.put(column.get(i),result.getObject(i+1));
				}
				list.add(map);
			}
			return list;
		} catch (SQLException e) {
			throw e;
		}finally {
			preparedStatement.close();
		}
	}
}
