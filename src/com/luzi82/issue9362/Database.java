package com.luzi82.issue9362;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

	private static final int VERSION = 1;
	private static final String DB_NAME = "issue9362";

	public Database(Context context) {
		super(context, DB_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE record ("
				+ " id INTEGER PRIMARY KEY AUTOINCREMENT ," + " log TEXT"
				+ " )");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// nothing
	}

	static public class Entry {
		String log;
	}

	static public void addRecord(Context context, String log) {
		Database db = new Database(context);
		Entry e = new Entry();
		e.log = log;
		db.addRecord(e);
	}

	public synchronized void addRecord(Entry entry) {
		SQLiteDatabase db = getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("log", entry.log);

		db.insert("record", null, values);

		db.close();
		close();
	}

	public synchronized List<Entry> getRecord() {
		LinkedList<Entry> ret = new LinkedList<Entry>();

		SQLiteDatabase db = getReadableDatabase();

		Cursor c = db.query("record", new String[] { "log" }, null, null, null,
				null, "id");

		c.moveToFirst();
		while (!c.isAfterLast()) {
			Entry e = new Entry();
			e.log = c.getString(0);
			ret.add(e);
			c.moveToNext();
		}
		c.close();

		db.close();
		close();

		return ret;
	}

	public synchronized void clearAll() {
		SQLiteDatabase db = getWritableDatabase();

		db.delete("record", null, null);

		db.close();
		close();
	}

}
