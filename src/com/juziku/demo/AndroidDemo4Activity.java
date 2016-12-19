package com.juziku.demo;

import com.juziku.demo.test.UserDaoTest;

import android.app.Activity;
import android.content.Context;
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
        Button createDatabase = (Button) findViewById(R.id.create_database);
        userDaoTest=new UserDaoTest();
        nContext=this;
        createDatabase.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		userDaoTest.testSaveUser(nContext);
        	}
        	});
    }
}