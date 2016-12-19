package com.juziku.demo.dao;

import android.content.Context;

import com.juziku.demo.data.User;
import com.juziku.demo.sqlite.BaseDao;

/**
 * DAO   需要继承BaseDao
 * 
 * @author steven
 * 
 * http://www.juziku.com/sunlightcs/
 *
 */
public class UserDao extends BaseDao<User> {

	public UserDao(Context context) {
		super(context);
	}

}
