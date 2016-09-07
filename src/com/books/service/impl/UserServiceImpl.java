package com.books.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.books.bean.User;
import com.books.dao.i.DaoI;
import com.books.dao.impl.DaoImpl;
import com.books.service.i.UserServiceI;

public class UserServiceImpl implements UserServiceI{
	private DaoI dao = new DaoImpl();
	/**
	 *ÓÃ»§×¢²á 
	 * @throws Exception 
	 */

	@Override
	public boolean register(User user) throws Exception {
		List<Map<String, Object>> result = dao.query("select count(1) as count from t_user where user_name=?",
				user.getUserName());
		if ("0".equals(String.valueOf(result.get(0).get("count")))) {
			return dao.exec("insert into t_user(user_name,password,type)values(?,?,?)",
					user.getUserName(),user.getPassword(),user.getType());			
		}else {
			return false;
		}
	}
	
		
	
}
