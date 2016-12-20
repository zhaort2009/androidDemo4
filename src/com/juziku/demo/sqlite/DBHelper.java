package com.juziku.demo.sqlite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {

	private Context mContext;

	public DBHelper(Context context, String databaseName,
			CursorFactory factory, int version) {
		super(context, databaseName, factory, version);
		mContext = context;
	}

	/**
	 * 数据库第一次创建时调用
	 * */
	@Override
	public void onCreate(SQLiteDatabase db) {
		executeSchema(db, "schema.sql");
		Log.w("Helper.onCreat", "创建数据库");
		Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT). show();
	}

	/**
	 * 数据库升级时调用
	 * */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//数据库不升级
		if (newVersion <= oldVersion) {
			return;
		}
		Configuration.oldVersion = oldVersion;

		int changeCnt = newVersion - oldVersion;
		for (int i = 0; i < changeCnt; i++) {
			// 依次执行updatei_i+1文件      由1更新到2 [1-2]，2更新到3 [2-3]
			String schemaName = "update" + (oldVersion + i) + "_"
					+ (oldVersion + i + 1) + ".sql";
			executeSchema(db, schemaName);
			Log.w("Helper.onUpgrade", "更新数据库"+(i+1)+"次");
		}
	}

	/**
	 * 读取数据库文件（.sql），并执行sql语句
	 * */
	private void executeSchema(SQLiteDatabase db, String schemaName) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(mContext.getAssets()
					.open(Configuration.DB_PATH + "/" + schemaName)));
			String line;
			String buffer = "";
			while ((line = in.readLine()) != null) {
				buffer += line;
				if (line.trim().endsWith(";")) {
					String zstring=buffer.replace(";", "");
					Log.w("create_sql", zstring);
					db.execSQL(zstring);
					Log.w("execSQL_db", zstring);
					buffer = "";
				}
			}
		} catch (IOException e) {
			Log.e("db-error", e.toString());
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				Log.e("db-error", e.toString());
			}
		}
	}

}