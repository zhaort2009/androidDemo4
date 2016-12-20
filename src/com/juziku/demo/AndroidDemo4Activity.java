package com.juziku.demo;

import com.juziku.demo.dao.UserDao;
import com.juziku.demo.test.UserDaoTest;
import com.juziku.demo.test.WriteSchema;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AndroidDemo4Activity extends Activity {
    /** Called when the activity is first created. */
    public Context nContext;
    public UserDaoTest userDaoTest;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //创建数据库按钮
        nContext=this;
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		UserDao dao=new UserDao(nContext);
        	}
        	});
        
        
        
        //插入数据按钮
        Button insertButton = (Button) findViewById(R.id.insert_data);
        userDaoTest=new UserDaoTest();
        nContext=this;
        insertButton.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		userDaoTest.testSaveUser(nContext);
        	}
        	});
        
        //查询数据库按钮
        Button queryButton = (Button) findViewById(R.id.query_data);
        queryButton.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		userDaoTest.testFindUserAll(nContext);
        	}
        	});
    }
}