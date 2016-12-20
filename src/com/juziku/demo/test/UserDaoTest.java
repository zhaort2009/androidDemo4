package com.juziku.demo.test;

import java.util.List;

import android.R.id;
import android.content.ContentValues;
import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;

import com.juziku.demo.dao.UserDao;
import com.juziku.demo.data.User;

/**
 * 测试用例
 * 
 * @author steven
 * 
 * http://www.juziku.com/sunlightcs/
 *
 */
public class UserDaoTest extends AndroidTestCase {
	
	public void testSaveUser(Context tcontext){
		UserDao dao = new UserDao(tcontext);
		ContentValues values = new ContentValues();
		values.put("id", 1);
		values.put("userId", 211);
		values.put("name", "张三");
		
		dao.insert("user", values);
		
		dao.close();
		System.out.print("创建user表并插入211张三");
	}
	
	
	public void testFindUser(Context tcontext){
		UserDao dao = new UserDao(tcontext);
		
		User user = dao.queryObject(User.class, "user", new String[]{"*"}, "id=?", new String[]{"1"});
		System.out.println("id:" + user.getId() + "  userId:" + user.getUserId() + "  name:" + user.getName());
		
		dao.close();
	}
	
	
	public void testFindUserAll(Context tcontext){
		UserDao dao = new UserDao(tcontext);
		
		List<User> userList = (List<User>)dao.queryList(User.class, "user", new String[]{"*"}, null, null, null, null, null);
		for(User user : userList){
			System.out.println("id:" + user.getId() + "  userId:" + user.getUserId() + "  name:" + user.getName());
			String msg="id:" + user.getId() + "  userId:" + user.getUserId() + "  name:" + user.getName();
		    Log.w("query_user", msg);
		}
		
		
		dao.close();
	}
}
