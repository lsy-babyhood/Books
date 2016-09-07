package com.books.service.i;

import java.sql.SQLException;

public interface UserServiceI {
	public boolean register(com.books.bean.User user) throws SQLException, Exception;
}
