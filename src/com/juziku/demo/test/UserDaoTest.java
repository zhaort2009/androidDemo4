package com.juziku.demo.test;

import java.util.List;

import android.content.ContentValues;
import android.test.AndroidTestCase;

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
	
	public void testSaveUser(){
		UserDao dao = new UserDao(this.getContext());
		ContentValues values = new ContentValues();
		values.put("userId", 211);
		values.put("name", "张三");
		
		dao.insert("user", values);
		
		dao.close();
		System.out.print("创建user表并插入211张三");
	}
	
	
	public void testFindUser(){
		UserDao dao = new UserDao(this.getContext());
		
		User user = dao.queryObject(User.class, "user", new String[]{"*"}, "id=?", new String[]{"1"});
		System.out.println("id:" + user.getId() + "  userId:" + user.getUserId() + "  name:" + user.getName());
		
		dao.close();
	}
	
	
	public void testFindUserAll(){
		UserDao dao = new UserDao(this.getContext());
		
		List<User> userList = (List<User>)dao.queryList(User.class, "user", new String[]{"*"}, null, null, null, null, null);
		for(User user : userList)
			System.out.println("id:" + user.getId() + "  userId:" + user.getUserId() + "  name:" + user.getName());
		
		dao.close();
	}
}
