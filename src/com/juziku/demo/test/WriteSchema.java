package com.juziku.demo.test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.content.Context;

public class WriteSchema {

	public static void save(String inputText,Context sContext) {
		FileOutputStream out = null;
		BufferedWriter writer = null;
		try {
		 out = sContext.openFileOutput("schema.sql", Context.MODE_PRIVATE);
		 writer = new BufferedWriter(new OutputStreamWriter(out));
		 writer.write(inputText);
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		        try {
		               if (writer != null) {
		               writer.close();
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		  }
		
		
	}
	//方法结束

}
